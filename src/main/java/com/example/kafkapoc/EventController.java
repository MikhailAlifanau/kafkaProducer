package com.example.kafkapoc;

import com.example.kafkapoc.model.Address;
import com.example.kafkapoc.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    KafkaSender kafkaSender;

    @GetMapping(value = "/message")
    public String producer(@RequestParam("message") String message) {
        //kafkaSender.send(message);

        return "Message sent to the Kafka Topic topic1 Successfully";
    }

    @GetMapping(value = "/future-message")
    public String futureMessage(@RequestParam("message") String message){
      // kafkaSender.sendFutureMessage(message);
        return "Future Message sent to the Kafka Successfully";
    }
    @GetMapping(value = "/user-message")
    public String userMessage(){
        UserDTO dto = new UserDTO();
        dto.setAge(2L);
        dto.setName("Guy");
        dto.setAddress(new Address("coutry", "city"));
       kafkaSender.sendUserDTO(dto);
        return "Future Message sent to the Kafka Successfully";
    }

}
