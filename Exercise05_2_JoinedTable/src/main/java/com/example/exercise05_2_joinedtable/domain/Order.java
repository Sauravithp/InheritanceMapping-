package com.example.exercise05_2_joinedtable.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Order")
@Table(name = "Tbl_Order")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String orderId;

    @Column
    private Date date;

    @OneToMany
    @JoinColumn(name = "Order_Id")
    private List<OrderLine> orderLineList;
}
