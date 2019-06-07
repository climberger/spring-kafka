package de.cl.playground.spring.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    private String bootstrapAddress = "localhost:9092";

    private String messageTopic = "message";

    private String greetingTopic = "greeting";

    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic messageTopic() {
        return new NewTopic(messageTopic, 1, (short) 1);
    }

    @Bean
    public NewTopic greetingTopic() {
        return new NewTopic(greetingTopic, 1, (short) 1);
    }
}
