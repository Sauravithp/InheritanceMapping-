package com.example.exercise05_2.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "CD")
@DiscriminatorValue("CD")
@Getter
@Setter
@ToString
public  class CD extends Product{

    @Column
    private String artist;
}
