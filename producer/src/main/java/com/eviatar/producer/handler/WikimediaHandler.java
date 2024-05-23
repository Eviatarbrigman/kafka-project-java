package com.eviatar.producer.handler;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaHandler implements BackgroundEventHandler {


    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaHandler.class);
    private KafkaTemplate<String, String> template;
    private String topic;


    public WikimediaHandler(KafkaTemplate<String, String> template, String topic) {
        this.template = template;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info("messgae" + " : --> "+ messageEvent.getData());
        template.send(topic , messageEvent.getData());

    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
