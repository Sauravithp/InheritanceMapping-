package com.example.exercise05_2_concreteclass.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "CD")
@Getter
@Setter
@ToString
public  class CD extends Product {

    @Column
    private String artist;
}
