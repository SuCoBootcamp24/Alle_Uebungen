package de.supercode.bootsverleih.reposetory;

import de.supercode.bootsverleih.entity.Boot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public interface BootRepository extends CrudRepository<Boot, long> {

}
