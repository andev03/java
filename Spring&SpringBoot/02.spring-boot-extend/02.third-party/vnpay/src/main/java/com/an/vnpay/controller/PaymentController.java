package com.an.vnpay.controller;

import com.an.vnpay.dto.PaymentDto;
import com.an.vnpay.dto.ResponseDto;
import com.an.vnpay.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/vnpay")
    public ResponseDto<PaymentDto> testPayment(HttpServletRequest request){
        return new ResponseDto<>(HttpStatus.OK, "Success", paymentService.paymentDto(request));
    }
}
