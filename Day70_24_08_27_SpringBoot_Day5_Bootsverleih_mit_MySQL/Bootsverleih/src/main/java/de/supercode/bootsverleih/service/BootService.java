package de.supercode.bootsverleih.service;

import de.supercode.bootsverleih.entity.Boot;
import de.supercode.bootsverleih.reposetory.BootRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BootService {

    private BootRepository bootRepository;

    public BootService(BootRepository bootRepository) {
        this.bootRepository = bootRepository;
    }


    public Optional<Boot> getBoot(Long id) {
        return bootRepository.findById(id);
    }


    public List<Boot> getBootsContainsName(String name) {
        Iterable<Boot> bootList = bootRepository.findAll();
        List<Boot> result = new ArrayList<>();
        bootList.forEach(result::add);
        return result.stream()
               .filter(boot -> boot.getName().toLowerCase().contains(name.toLowerCase()))
               .collect(Collectors.toList());
    }

    public Boot addBoot(Boot boot) {
        return bootRepository.save(boot);
    }

    public List<Boot> getAllBoots() {
        List<Boot> allBoots = new ArrayList<>();
        bootRepository.findAll().forEach(allBoots::add);
        return allBoots;
    }

    public Boot updateBoot(Boot updateBoot) {
        Optional<Boot> existBoot = bootRepository.findById(updateBoot.getId());

        if(existBoot.isPresent()) {
            existBoot.get().setName(updateBoot.getName());
            existBoot.get().setCategory(updateBoot.getCategory());
            existBoot.get().setCapacity(updateBoot.getCapacity());
            existBoot.get().setAvailable(updateBoot.isAvailable());
            return bootRepository.save(existBoot.get());
        }
        return null;
    }

    public List<Boot> getBootsByCategory(String category) {
        return getAllBoots().stream()
               .filter(boot -> boot.getCategory().equalsIgnoreCase(category))
               .collect(Collectors.toList());
    }

    public List<Boot> getAvailableBoots(boolean available) {
        return getAllBoots().stream()
               .filter(boot -> boot.isAvailable() == available)
               .collect(Collectors.toList());
    }

    public boolean deleteBoot(Long bootId) {
        Optional<Boot> existBoot = getBoot(bootId);
        if(existBoot.isPresent()) {
            bootRepository.delete(existBoot.get());
            return true;
        }
        return false;
    }

    public long countExistBoots() {
        return bootRepository.count();
    }

}
