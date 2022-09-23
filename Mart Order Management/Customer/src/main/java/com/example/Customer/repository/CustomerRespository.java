package com.example.Customer.repository;

import com.example.Customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository extends MongoRepository<Customer,String> {

}