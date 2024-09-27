package de.supercode.bootsverleih.controller;

import de.supercode.bootsverleih.entity.Boot;
import de.supercode.bootsverleih.service.BootService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/boote")
public class BootController {

    BootService bootService;

    public BootController(BootService bootService) {
        this.bootService = bootService;
    }


    @GetMapping("/search")
    public List<Boot> searchBoots(
            @RequestParam(required = false) Long bootId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Boolean available) {

        if (bootId != null) {
            Optional<Boot> exisBoot = bootService.getBoot(bootId);
            return exisBoot.isPresent()? List.of(exisBoot.get()) : null;
        } else if (name != null) {
            return bootService.getBootsContainsName(name);
        } else if (category != null) {
            return bootService.getBootsByCategory(category);
        } else if (available != null) {
            return bootService.getAvailableBoots(available);
        } else {
            return bootService.getAllBoots();
        }
    }

    @GetMapping("/count")
    public long countExistBoots() {
        return bootService.countExistBoots();
    }

    @PostMapping
    public Boot addBoot(@RequestBody Boot boot) {
        return bootService.addBoot(boot);
    }

    @PutMapping
    public Boot updateBoot(@RequestBody Boot updateBoot) {
        return bootService.updateBoot(updateBoot);
    }

    @DeleteMapping
    public boolean deleteBoot(@RequestParam Long bootId) {
        return bootService.deleteBoot(bootId);
    }
}
