package de.supercode.shoppinglist.repositorys;


import de.supercode.shoppinglist.entitys.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Optional<Item> findByName(String name);
}
