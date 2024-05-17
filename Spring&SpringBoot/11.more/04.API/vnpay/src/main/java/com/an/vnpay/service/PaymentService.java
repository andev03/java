package com.an.vnpay.service;

import com.an.vnpay.Utils;
import com.an.vnpay.config.Config;
import com.an.vnpay.dto.PaymentDto;
import com.an.vnpay.dto.ResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class PaymentService {
    private final Config config;

    @Autowired
    public PaymentService(Config config) {
        this.config = config;
    }

    public PaymentDto paymentDto(HttpServletRequest request){
        long amount = Integer.parseInt(request.getParameter("amount")) * 100L;
        String bankCode = "NCB";
        Map<String, String> vnpParamsMap = Config.getVNPayConfig();
        vnpParamsMap.put("vnp_Amount", String.valueOf(amount));
        vnpParamsMap.put("vnp_IpAddr", Utils.getIpAddress(request));
        vnpParamsMap.put("vnp_BankCode", bankCode);
        //build query url
        String queryUrl = Utils.getPaymentURL(vnpParamsMap, true);
        String hashData = Utils.getPaymentURL(vnpParamsMap, false);
        String vnpSecureHash = Utils.hmacSHA512(Utils.getSecretKey(), hashData);
        queryUrl += "&vnp_SecureHash=" + vnpSecureHash;
        String paymentUrl = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html" + "?" + queryUrl;
        return PaymentDto.builder()
                .code("ok")
                .message("success")
                .paymentUrl(paymentUrl).build();
    }
}
