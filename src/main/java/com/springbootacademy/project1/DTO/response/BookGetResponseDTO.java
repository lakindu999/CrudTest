package com.springbootacademy.project1.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookGetResponseDTO {
    private int bookId;
    private String bookName;
    private Date returnDate;
}
