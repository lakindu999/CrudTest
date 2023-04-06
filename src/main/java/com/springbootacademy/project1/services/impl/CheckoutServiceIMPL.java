package com.springbootacademy.project1.services.impl;

import com.springbootacademy.project1.DTO.request.RequestCheckoutSaveDTO;
import com.springbootacademy.project1.entity.Checkout;
import com.springbootacademy.project1.entity.CheckoutDetail;
import com.springbootacademy.project1.repo.BookRepo;
import com.springbootacademy.project1.repo.CheckoutDetailRepo;
import com.springbootacademy.project1.repo.CheckoutRepo;
import com.springbootacademy.project1.repo.StudentRepo;
import com.springbootacademy.project1.services.CheckoutService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CheckoutServiceIMPL implements CheckoutService {

    @Autowired
    private CheckoutRepo checkoutRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CheckoutDetailRepo checkoutDetailRepo;

    @Override
    @Transactional
    public String addCheckout(RequestCheckoutSaveDTO requestCheckoutSaveDTO) {
        Checkout checkout = new Checkout(
                studentRepo.getReferenceById(requestCheckoutSaveDTO.getStudent()),
                requestCheckoutSaveDTO.getTotalValue()
        );
        checkoutRepo.save(checkout);

        if (checkoutRepo.existsById(checkout.getCheckoutId())){
            List<CheckoutDetail> checkoutDetails =  modelMapper.map(requestCheckoutSaveDTO,new TypeToken<List<CheckoutDetail>>(){}.getType());
            for (int i=0;i<checkoutDetails.size();i++){
                checkoutDetails.get(i).setCheckout(checkout);
                checkoutDetails.get(i).setBooks(bookRepo.getReferenceById(requestCheckoutSaveDTO.getCheckoutDetails().get(i).getBooks()));
            }
            if (checkoutDetails.size()>0){
                checkoutDetailRepo.saveAll(checkoutDetails);
            }
            return "Saved";

        }
        return null;
    }
}
