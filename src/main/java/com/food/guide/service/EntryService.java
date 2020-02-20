package com.food.guide.service;

import com.food.guide.domain.Entry;

import java.util.List;

public interface EntryService {
    Entry createProduct(Entry entry);
    Entry updateProduct(Entry entry);
    List<Entry> getAllProduct();
    Entry getProductById(long id);
    void deleteProduct(long id);
}
