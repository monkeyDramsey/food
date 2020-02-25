package com.food.guide.logic;

import com.food.guide.domain.Blogger;
import com.food.guide.domain.Entry;

import java.util.List;

public interface WorkLogFacade {
    Entry createEntry(Entry entry);
    Entry updateEntry(Entry entry);
    List<Entry> getAllEntries();
    Entry getEntryById(long id);
    void deleteEntry(long id);

    Blogger syncBlogger(Blogger blogger);
    List<Blogger> findAllBlogger();
}
