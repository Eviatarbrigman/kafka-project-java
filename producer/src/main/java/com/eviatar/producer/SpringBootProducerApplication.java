package com.eviatar.producer;


import com.eviatar.producer.producer.WikimediaProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootProducerApplication implements CommandLineRunner {

    public SpringBootProducerApplication(WikimediaProducer wikimediaProducer) {
        this.wikimediaProducer = wikimediaProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class);
    }

    private WikimediaProducer wikimediaProducer;

    @Override
    public void run(String... args) throws Exception {
        wikimediaProducer.sendMessage();

    }
}
