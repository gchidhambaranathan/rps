package com.chidha.rps.controller;


import com.chidha.rps.model.Payment;
import com.chidha.rps.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    @Autowired
    private PaymentService paymentService;

    @PostMapping(path = "/")
    public ResponseEntity<Payment> payment(@RequestBody Payment payment) {
        ResponseEntity<Payment> responseEntity;
        try {
            Payment payment1 = paymentService.payment(payment);
            responseEntity = new ResponseEntity<>(payment1, HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
