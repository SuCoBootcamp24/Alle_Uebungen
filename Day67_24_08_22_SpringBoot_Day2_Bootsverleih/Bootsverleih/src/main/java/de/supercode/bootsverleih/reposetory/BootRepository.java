package de.supercode.bootsverleih.reposetory;

import de.supercode.bootsverleih.entity.Boot;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootRepository {

    private static long lastID = 0;
    private List<Boot> bootList;

    public BootRepository() {
        this.bootList = new ArrayList<>();
    }

    public Boot addBoot(Boot boot) {
        boot.setId(lastID++);
        bootList.add(boot);
        return boot;
    }

    public List<Boot> getAllBoots() {
        return bootList;
    }

    public Boot getBootById(Long id) {
        return bootList.stream()
                .filter(boot -> boot.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public boolean deleteBootById(Long id) {
        Boot existBoot = bootList.stream()
                .filter(boot -> boot.getId() == id)
                .findFirst()
                .orElse(null);
        if (existBoot!= null) {
            bootList.remove(existBoot);
            return true;
        };
        return false;
    }

    public Boot updateBoot(Boot updatedBoot) {
        int index = bootList.indexOf(bootList.stream()
               .filter(boot -> boot.getId() == updatedBoot.getId())
               .findFirst()
               .orElse(null));
        if (index>= 0) {
            bootList.set(index, updatedBoot);
            return updatedBoot;
        }
        return null;
    }

}
