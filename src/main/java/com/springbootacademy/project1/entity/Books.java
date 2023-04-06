package com.springbootacademy.project1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Data


public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id",length = 100)
    private int bookId;

    @Column(name = "book_name",length = 100)
    private String bookName;

    @Column(name = "book_value", length = 20)
    private double bookValue;

    @Column(name = "borrow_date", length = 20)
    @Temporal(TemporalType.DATE)
    private Date borrowDate;

    @Column(name = "return_date", length = 20)
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @Column(name = "active_status", columnDefinition = "TINYINT default 1")
    private boolean activeStatus;

//    @OneToMany(mappedBy = "student")
//    private Set<CheckoutDetail> checkoutDetails;

    @OneToMany(mappedBy = "books")
    private Set<CheckoutDetail> checkoutDetails;


}
