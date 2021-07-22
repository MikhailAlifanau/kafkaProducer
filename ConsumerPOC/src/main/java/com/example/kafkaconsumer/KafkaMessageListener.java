package com.example.kafkaconsumer;

import com.example.kafkaconsumer.model.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {
    @Value("${kafka.group.id}")
    private String kafkaGroupId;

    @KafkaListener(topics = "topic1", groupId = "string_group")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }

    @KafkaListener(topics = "topic2", groupId = "string_group")
    public void listenGroupFoo2(String message) {
        System.out.println("Topic 2: " + message);
    }
    @KafkaListener(topics = "topic3", groupId = "json_group", containerFactory = "userKafkaListenerFactory")
    public void listenGroupFoo3(UserDTO message) {
        System.out.println("Topic 3: " + message.getName());
        System.out.println("Topic 3: " + message.getAddress());
        System.out.println("Topic 3: " + message.getAddress().getCity());
    }
}
