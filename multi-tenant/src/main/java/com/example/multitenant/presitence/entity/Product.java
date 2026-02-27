package com.example.multitenant.presitence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(value = "product")
@ToString
public class Product {

    @Id
    private Long id;
    private String name;
    private Double price;

}