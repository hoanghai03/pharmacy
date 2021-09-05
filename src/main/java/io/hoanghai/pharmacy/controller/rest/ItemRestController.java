package io.hoanghai.pharmacy.controller.rest;

import io.hoanghai.pharmacy.model.Item;
import io.hoanghai.pharmacy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemRestController {

    private ItemService itemService;
    private Object JsonUtil;

    @Autowired
    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item")
    public List<Item> get(){
        return itemService.findAll(true);
    }

    @GetMapping("/item/{id}")
    public Item get(@PathVariable(value = "id") Integer id){
        return itemService.findById(id);
    }

    @GetMapping("/random/item")
    public List<Item> random() {
        List<Item> items = itemService.findAll(true);
        Collections.shuffle(items);
        int n = items.size();
        if (n > 12) return items.subList(0, 12);
        else return items;
    }

    @PostMapping("/create")
    public String save(@RequestBody Item item, RedirectAttributes redirect) {
        try {
            itemService.save(item);
            return "đã lưu";
        } catch(Exception e) {
            return "lỗi";
        }
    }

    @PostMapping("/{id}/edit")
    public String update(@RequestBody Item item, @PathVariable int id, RedirectAttributes redirect) {
        try {
            itemService.update(item, id);
            return "đã update";
        } catch(Exception e) {
            return "update lỗi";
        }
    }

    @DeleteMapping("/{id}/delete")
    public Item destroy(@PathVariable(value = "id") Integer id, RedirectAttributes redirect) {
        try {
            Item item = itemService.delete(id);
            return item;
        } catch(Exception e) {
            return null;
        }
    }

}
