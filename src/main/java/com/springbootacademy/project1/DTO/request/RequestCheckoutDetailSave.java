package com.springbootacademy.project1.DTO.request;

import com.springbootacademy.project1.entity.Books;
import com.springbootacademy.project1.entity.Checkout;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCheckoutDetailSave {

        private String bookName;
        private double bookValue;
        private int books;
        private int checkout;


}
