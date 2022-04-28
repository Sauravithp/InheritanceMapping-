package com.example.exercise05_1.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "OrderLine")
@Table(name = "OrderLine")
@Getter
@Setter
@RequiredArgsConstructor
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Product_Id")
    private Product productList;
}
