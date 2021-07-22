package com.example.kafkapoc;

import com.example.kafkapoc.model.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
public class KafkaSender {

    private final KafkaTemplate<String, UserDTO> kafkaTemplate;

//    public void send(String msg){
//        kafkaTemplate.send("topic1", msg);
//    }
//
//    public void sendFutureMessage(String message) {
//
//        ListenableFuture<SendResult<String, Object>> future =
//                kafkaTemplate.send("topic2", message);
//
//        future.addCallback(System.out::println, System.err::println);
//    }

    public void sendUserDTO(UserDTO dto){
        kafkaTemplate.send("topic3", dto);
    }

}
