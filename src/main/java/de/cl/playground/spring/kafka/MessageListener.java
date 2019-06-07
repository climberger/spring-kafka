package de.cl.playground.spring.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "message", groupId = "message-group", containerFactory = "messageKafkaListenerContainerFactory")
    public void listenGroupFoo(@Payload String message, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) {
        System.out.println("Received message in group 'message-group':\nkey=" + key + "\nmessage=" + message);
    }

    @KafkaListener(topics = "greeting", containerFactory = "greetingKafkaListenerContainerFactory")
    public void greetingListener(Greeting greeting) {
        System.out.println("Recieved greeting message: " + greeting);
    }

}
