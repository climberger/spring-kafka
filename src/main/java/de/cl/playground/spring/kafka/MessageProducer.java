package de.cl.playground.spring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Greeting> greetingKafkaTemplate;

    private String messageTopicName = "message";
    private String greetingTopicName = "greeting";

    public void sendMessage(String message) {
        kafkaTemplate.send(messageTopicName, new Date().toString(), message);
    }

    public void sendGreetingMessage(Greeting greeting) {
        greetingKafkaTemplate.send(greetingTopicName, new Date().toString(), greeting);
    }

}
