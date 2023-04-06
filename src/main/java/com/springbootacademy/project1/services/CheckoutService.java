package com.springbootacademy.project1.services;

import com.springbootacademy.project1.DTO.request.RequestCheckoutSaveDTO;

public interface CheckoutService {
    String addCheckout(RequestCheckoutSaveDTO requestCheckoutSaveDTO);
}
