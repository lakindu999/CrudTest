package com.springbootacademy.project1.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "checkout_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckoutDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "checkout_detail_id",length = 100)
    private int checkoutDetailId;

    @Column(name = "book_name",length = 100)
    private String bookName;

    @Column(name = "book_value", length = 20)
    private double bookValue;

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Books books;

    @ManyToOne
    @JoinColumn(name = "checkout_id",nullable = false)
    private Checkout checkout;


}
