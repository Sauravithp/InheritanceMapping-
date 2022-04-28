package com.example.exercise05_2_joinedtable.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "Product")
@Table(name = "Product")
@Getter
@Setter
@ToString
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;
}
