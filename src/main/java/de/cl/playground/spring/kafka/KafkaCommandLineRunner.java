package de.cl.playground.spring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class KafkaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private MessageProducer messageProducer;

    private int count = 0;

    @Override
    public void run(String...args) {
        String message = "This is message number " + ++count;
        System.out.println("Send message: " + message);
        messageProducer.sendMessage(message);

        Greeting greeting = new Greeting("Hello","John Wick");
        System.out.println("Send Message: " + message);

        messageProducer.sendGreetingMessage(greeting);
    }
}