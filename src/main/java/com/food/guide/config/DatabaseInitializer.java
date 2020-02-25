package com.food.guide.config;

import com.food.guide.domain.Blogger;
import com.food.guide.domain.Entry;
import com.food.guide.logic.WorkLogFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private WorkLogFacade workLogFacade;

    @Override
    public void run(String... args) throws Exception {
        Blogger blogger1 = new Blogger("rene", "rene@gmail.com", "save");
        blogger1.addEntry(new Entry("Haidershofen", "Trilogie", "Pizza Diavolo", "Weihenstephan"));
        workLogFacade.syncBlogger(blogger1);
    }
}
