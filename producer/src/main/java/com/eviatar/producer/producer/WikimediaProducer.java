package com.eviatar.producer.producer;

import com.eviatar.producer.handler.WikimediaHandler;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;


@Service
public class WikimediaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaProducer.class);
    private KafkaTemplate<String, String> template;

    @Autowired
    public WikimediaProducer(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia12";
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";


        BackgroundEventHandler eventHandler = new WikimediaHandler(template, topic);
        URI uri = URI.create(url);
        EventSource.Builder esBuilder = new EventSource.Builder(uri);
        BackgroundEventSource.Builder eventSource = new BackgroundEventSource.Builder(eventHandler, esBuilder);
        BackgroundEventSource source = eventSource.build();
        source.start();

        TimeUnit.MINUTES.sleep(10);

    }
}
