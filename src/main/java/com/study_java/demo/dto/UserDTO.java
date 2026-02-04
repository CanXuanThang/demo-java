package com.study_java.demo.dto;

import com.study_java.demo.models.Order;

import java.util.List;

public class UserDTO {
    private  Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Order> orders;
}
