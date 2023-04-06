package com.springbootacademy.project1.DTO.request;


import com.springbootacademy.project1.entity.CheckoutDetail;
import com.springbootacademy.project1.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCheckoutSaveDTO {

    private Double totalValue;
    private int student;
    private List<RequestCheckoutDetailSave> checkoutDetails;

}
