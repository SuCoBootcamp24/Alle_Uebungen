package de.supercode.shoppinglist.controllers;

import de.supercode.shoppinglist.entitys.Item;
import de.supercode.shoppinglist.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/list")
@CrossOrigin
public class ItemController {

    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity createItem(@RequestBody Item item) {
        Item newItem = itemService.createItem(item);
        if (newItem == null) return ResponseEntity.badRequest().build();
        else return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAllItems() {
        return itemService.getAllItems();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item updatedItem = itemService.updateItem(id, item);
        if (updatedItem == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        if (itemService.deleteItem(id)) return ResponseEntity.ok().build();
        else return ResponseEntity.notFound().build();
    }

}
