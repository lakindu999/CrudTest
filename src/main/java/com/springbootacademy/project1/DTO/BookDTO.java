package com.springbootacademy.project1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {

    private int bookId;
    private String bookName;
    private double bookValue;
    private Date borrowDate;
    private Date returnDate;
    private boolean activeStatus;
}
