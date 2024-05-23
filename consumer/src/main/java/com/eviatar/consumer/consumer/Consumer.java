package com.eviatar.consumer.consumer;

import com.eviatar.consumer.model.WikimediaData;
import com.eviatar.consumer.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    private WikimediaRepository wikimediaRepository;

    public Consumer(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(topics = "wikimedia12", groupId = "eviatar12")
    private void consume(String message) {
        LOGGER.info("Event message" + message);
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiData(message.substring(0,100));
        wikimediaRepository.save(wikimediaData);
    }
}
