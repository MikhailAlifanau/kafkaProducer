package com.example.kafkapoc.model;

import lombok.Data;

@Data
public class UserDTO {
    private Long age;
    private String name;
    private Address address;
}
