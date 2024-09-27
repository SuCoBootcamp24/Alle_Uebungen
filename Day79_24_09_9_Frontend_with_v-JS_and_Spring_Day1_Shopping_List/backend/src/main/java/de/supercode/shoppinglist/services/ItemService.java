package de.supercode.shoppinglist.services;

import de.supercode.shoppinglist.entitys.Item;
import de.supercode.shoppinglist.repositorys.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item) {
        Optional<Item> existItem = itemRepository.findByName(item.getName());
        if (existItem.isPresent()) return null;
        else return itemRepository.save(item);
    }

    public ResponseEntity getAllItems() {
        return ResponseEntity.ok(itemRepository.findAll());
    }

    public boolean deleteItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            itemRepository.deleteById(id);
            return true;
        } else return false;
    }

    public Item updateItem(Long id, Item item) {
        Optional<Item> existItem = itemRepository.findById(id);
        if (existItem.isPresent()) {
            existItem.get().setBought(item.isBought());
            return itemRepository.save(existItem.get());
        } else return null;
    }
}
