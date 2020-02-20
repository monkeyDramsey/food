package com.food.guide.controller;

import com.food.guide.domain.Entry;
import com.food.guide.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntryController {

    @Autowired
    private EntryService entryService;

    @GetMapping("/products")
    public ResponseEntity<List<Entry>> getAllProduct(){
        return ResponseEntity.ok().body(entryService.getAllProduct());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Entry> getProductById(@PathVariable long id){
        return ResponseEntity.ok().body(entryService.getProductById(id));
    }

    @PostMapping("/products")
    public ResponseEntity<Entry> createProduct(@RequestBody Entry entry){
        return ResponseEntity.ok().body(this.entryService.createProduct(entry));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Entry> updateProduct(@PathVariable long id, @RequestBody Entry entry){
        entry.setId(id);
        return ResponseEntity.ok().body(this.entryService.updateProduct(entry));
    }

    @DeleteMapping("products/{id}")
    public HttpStatus deleteProduct(@PathVariable long id){
        this.entryService.deleteProduct(id);
        return HttpStatus.OK;
    }
}
