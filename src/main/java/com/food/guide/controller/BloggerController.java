package com.food.guide.controller;

import com.food.guide.domain.Blogger;
import com.food.guide.domain.Entry;
import com.food.guide.logic.WorkLogFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BloggerController {

    @Autowired
    private WorkLogFacade workLogFacade;

    @PostMapping("/blogger")
    public ResponseEntity<Blogger> createBlogger(@RequestBody Blogger blogger){
        return ResponseEntity.ok().body(this.workLogFacade.syncBlogger(blogger));
    }

    @GetMapping("/bloggers")
    public ResponseEntity<List<Blogger>> getAllBlogger(){
        return ResponseEntity.ok().body(workLogFacade.findAllBlogger());
    }

}
