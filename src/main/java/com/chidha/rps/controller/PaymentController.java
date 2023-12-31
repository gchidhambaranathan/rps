package com.chidha.rps.controller;


import com.chidha.rps.model.Payment;
import com.chidha.rps.model.PaymentResponse;
import com.chidha.rps.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PaymentController {

    private Logger logger = LoggerFactory.getLogger(SchoolFeesDetailsController.class);

    @Autowired
    private PaymentService paymentService;

    @PostMapping(path = "/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PaymentResponse> payment(@RequestBody Payment payment) {
        ResponseEntity<PaymentResponse> responseEntity;
        try {
            PaymentResponse payment1 = paymentService.payment(payment);
            responseEntity = new ResponseEntity<>(payment1, HttpStatus.OK);
        }catch (Exception e){
            logger.error("Error doing payment", e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
