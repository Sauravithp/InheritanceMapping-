package com.example.exercise05_2_joinedtable.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Customer")
@Table(name = "Customer")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToMany
    @JoinColumn(name = "Customer_Id")
    private List<Order> orderList;
}
