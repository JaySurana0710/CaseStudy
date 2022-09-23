package com.example.Productservicec2.entity;


import lombok.*;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long prodId;


        @Column(name = "prodName")
        private String prodName;

        @Column(name = "prodQty")
        private String prodQty;

        @Column(name = "prodCost")
        private Long prodCost;



}