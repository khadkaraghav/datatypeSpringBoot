package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Book {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

@NotNull
private String name;

@NotNull
private String author;

@NotNull
private double price;

@NotNull
private boolean isGood;
}
