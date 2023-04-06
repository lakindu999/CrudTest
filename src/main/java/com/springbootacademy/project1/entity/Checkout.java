package com.springbootacademy.project1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "checkout")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "checkout_id",length = 100)
    private int checkoutId;

    @Column(name = "total_value",length = 100)
    private double totalValue;

    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;

    @OneToMany(mappedBy = "checkout")
    private Set<CheckoutDetail> checkoutDetails;


    public Checkout(Student referenceById, Double totalValue) {
    }
}
