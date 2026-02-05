package com.study_java.demo.dto;

import com.study_java.demo.models.Cart;
import com.study_java.demo.models.Order;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private  Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<OrderDTO> orders;
    private CartDTO cart;
}
