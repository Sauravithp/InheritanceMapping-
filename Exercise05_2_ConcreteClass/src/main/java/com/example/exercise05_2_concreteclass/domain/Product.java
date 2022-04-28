package com.example.exercise05_2_concreteclass.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "Product")
@Table(name = "Product")
@Getter
@Setter
@ToString
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;
}
