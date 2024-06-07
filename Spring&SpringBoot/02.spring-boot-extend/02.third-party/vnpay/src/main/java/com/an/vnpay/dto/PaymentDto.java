package com.an.vnpay.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDto {
    public String code;
    public String message;
    public String paymentUrl;


}
