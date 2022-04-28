package com.example.exercise05_2_concreteclass.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Book")
@Getter
@Setter
@ToString
public  class Book extends Product{

    @Column
    private String title;
}
