package com.example.Customer.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customer")
@ToString
public class Customer {
    @Id
    private String customerNumber;
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerCity;
    private String customerState;
    private String customerCountry;
}