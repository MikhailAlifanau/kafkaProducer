package com.example.kafkaconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long age;
    private String name;
    private Address address;
}
