package com.dhanesh.Customer_app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // It will generate Id automatically means no need to it manually..
    private Integer id;

    private String firstName;
    private String lastName;

    private String street;
    private String address;
    private String city;
    private String state;
    private String gender;
    private String email;

    private String username;
    private String contactNo;
    private String password;

}