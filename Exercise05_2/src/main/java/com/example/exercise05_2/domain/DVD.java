package com.example.exercise05_2.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "DVD")
@DiscriminatorValue("DVD")
@Getter
@Setter
@ToString
public  class DVD extends Product{

    @Column
    private String genre;
}
