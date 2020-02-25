package com.food.guide.controller;

import com.food.guide.domain.Entry;
import com.food.guide.logic.WorkLogFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntryController {

    @Autowired
    private WorkLogFacade workLogFacade;

    @GetMapping("/entries")
    public ResponseEntity<List<Entry>> getAllEntries(){
        return ResponseEntity.ok().body(workLogFacade.getAllEntries());
    }

    @GetMapping("/entries/{id}")
    public ResponseEntity<Entry> getEntryById(@PathVariable long id){
        return ResponseEntity.ok().body(workLogFacade.getEntryById(id));
    }

    @PostMapping("/entries")
    public ResponseEntity<Entry> createEntry(@RequestBody Entry entry){
        return ResponseEntity.ok().body(this.workLogFacade.createEntry(entry));
    }

    @PutMapping("/entries/{id}")
    public ResponseEntity<Entry> updateEntry(@PathVariable long id, @RequestBody Entry entry){
        entry.setId(id);
        return ResponseEntity.ok().body(this.workLogFacade.updateEntry(entry));
    }

    @DeleteMapping("entries/{id}")
    public HttpStatus deleteEntry(@PathVariable long id){
        this.workLogFacade.deleteEntry(id);
        return HttpStatus.OK;
    }
}
