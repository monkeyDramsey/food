package com.food.guide.logic;

import com.food.guide.dao.BloggerRepository;
import com.food.guide.domain.Blogger;
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
public class WorkLogFacadeImpl implements WorkLogFacade {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private BloggerRepository bloggerRepository;

    @Override
    public Entry createEntry(Entry entry) {
        return entryRepository.saveAndFlush(entry);
    }

    @Override
    public Entry updateEntry(Entry entry) {
        Optional<Entry> entryOptional = this.entryRepository.findById(entry.getId());
        if(entryOptional.isPresent()){
            Entry entryUpdate = entryOptional.get();
            entryUpdate.setId(entry.getId());
            entryUpdate.setLocation(entry.getLocation());
            entryUpdate.setHouse(entry.getHouse());
            entryUpdate.setDish(entry.getDish());
            entryUpdate.setDrink(entry.getDrink());

            entryRepository.saveAndFlush(entryUpdate);
            return entryUpdate;
        } else
            throw new ResourceNotFoundException("Record not found with id: " + entry.getId());
    }

    @Override
    public List<Entry> getAllEntries() {
        return this.entryRepository.findAll();
    }

    @Override
    public Entry getEntryById(long id) {
        Optional<Entry> entryOptional = this.entryRepository.findById(id);
        if(entryOptional.isPresent())
            return entryOptional.get();
        else
            throw new ResourceNotFoundException("Record not found with id: " + id);
    }

    @Override
    public void deleteEntry(long id) {
        Optional<Entry> entryOptional = this.entryRepository.findById(id);
        if(entryOptional.isPresent())
            this.entryRepository.delete(entryOptional.get());
        else
            throw new ResourceNotFoundException("Record not found with id: " + id);
    }

    @Override
    public Blogger syncBlogger(Blogger blogger) {
        return bloggerRepository.saveAndFlush(blogger);
    }
    //save() and saveAndFlush()

    //save(): the data associated with the save
    // operation will not be flushed to the DB unless and until an explicit
    // call to flush() or commit() method is made

    //saveAndFlush(): flushes the data immediately during the execution

    @Override
    public List<Blogger> findAllBlogger() {
        return bloggerRepository.findAll();
    }
}
