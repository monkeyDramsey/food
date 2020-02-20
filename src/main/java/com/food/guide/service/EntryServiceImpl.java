package com.food.guide.service;

import com.food.guide.exception.ResourceNotFoundException;
import com.food.guide.domain.Entry;
import com.food.guide.dao.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepository;

    @Override
    public Entry createProduct(Entry entry) {
        return entryRepository.save(entry);
    }

    @Override
    public Entry updateProduct(Entry entry) {
        Optional<Entry> productOptional = this.entryRepository.findById(entry.getId());
        if(productOptional.isPresent()){
            Entry entryUpdate = productOptional.get();
            entryUpdate.setId(entry.getId());
            entryUpdate.setLocation(entry.getLocation());
            entryUpdate.setHouse(entry.getHouse());
            entryUpdate.setDish(entry.getDish());
            entryUpdate.setDrink(entry.getDrink());

            entryRepository.save(entryUpdate);
            return entryUpdate;
        } else
            throw new ResourceNotFoundException("Record not found with id: " + entry.getId());
    }

    @Override
    public List<Entry> getAllProduct() {
        return this.entryRepository.findAll();
    }

    @Override
    public Entry getProductById(long id) {
        Optional<Entry> entryOptional = this.entryRepository.findById(id);
        if(entryOptional.isPresent())
            return entryOptional.get();
        else
            throw new ResourceNotFoundException("Record not found with id: " + id);
    }

    @Override
    public void deleteProduct(long id) {
        Optional<Entry> entryOptional = this.entryRepository.findById(id);
        if(entryOptional.isPresent())
            this.entryRepository.delete(entryOptional.get());
        else
            throw new ResourceNotFoundException("Record not found with id: " + id);
    }
}
