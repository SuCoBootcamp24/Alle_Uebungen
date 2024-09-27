package de.supercode.bootsverleih.service;

import de.supercode.bootsverleih.entity.Boot;
import de.supercode.bootsverleih.reposetory.BootRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BootService {

    private BootRepository bootRepository;

    public BootService(BootRepository bootRepository) {
        this.bootRepository = bootRepository;
    }



    public Boot getBoot(Long bootId) {
        return bootRepository.getBootById(bootId);
    }

    public List<Boot> getBootsContainsName(String name) {
        return bootRepository.getAllBoots().stream()
                .filter(boot -> boot.getName() != null && boot.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Boot addBoot(Boot boot) {
        return bootRepository.addBoot(boot);
    }

    public List<Boot> getAllBoots() {
        return bootRepository.getAllBoots();
    }

    public Boot updateBoot(Boot updateBoot) {
        Boot existBoot = bootRepository.getBootById(updateBoot.getId());

        if(existBoot!= null) {
            existBoot.setName(updateBoot.getName());
            existBoot.setCategory(updateBoot.getCategory());
            existBoot.setCapacity(updateBoot.getCapacity());
            existBoot.setAvailable(updateBoot.isAvailable());
            return bootRepository.updateBoot(existBoot);
        }
        return null;
    }

    public List<Boot> getBootsByCategory(String category) {
        return bootRepository.getAllBoots().stream()
               .filter(boot -> boot.getCategory().equalsIgnoreCase(category))
               .collect(Collectors.toList());
    }

    public List<Boot> getAvailableBoots(boolean available) {
        return bootRepository.getAllBoots().stream()
               .filter(boot -> boot.isAvailable() == available)
               .collect(Collectors.toList());
    }

    public boolean deleteBoot(Long bootId) {
        return bootRepository.deleteBootById(bootId);
    }

    public int countExistBoots() {
        return bootRepository.getAllBoots().size();
    }
}
