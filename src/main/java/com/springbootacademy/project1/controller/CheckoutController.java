package com.springbootacademy.project1.controller;

import com.springbootacademy.project1.DTO.SportDTO;
import com.springbootacademy.project1.DTO.request.RequestCheckoutSaveDTO;
import com.springbootacademy.project1.repo.CheckoutRepo;
import com.springbootacademy.project1.services.CheckoutService;
import com.springbootacademy.project1.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    //save
    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveSport(@RequestBody RequestCheckoutSaveDTO requestCheckoutSaveDTO) {
        String id = checkoutService.addCheckout(requestCheckoutSaveDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Saved", id), HttpStatus.CREATED);
        return responseEntity;
    }
}
