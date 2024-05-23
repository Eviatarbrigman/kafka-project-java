package com.eviatar.producer.controller;

import com.eviatar.producer.producer.WikimediaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("data")
public class wikimediaController {
    @Autowired
    private WikimediaProducer wikimediaProducer;

    public wikimediaController(WikimediaProducer wikimediaProducer) {
        this.wikimediaProducer = wikimediaProducer;
    }

    @GetMapping("/wikimedia")
    public void getData() throws InterruptedException {
        wikimediaProducer.sendMessage();
    }

}
