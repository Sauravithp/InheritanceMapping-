package com.example.exercise05_2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "DVD")
@DiscriminatorValue("DVD")
@Getter
@Setter
@ToString
public  class DVD extends Product{

    @Column
    private String genre;
}
