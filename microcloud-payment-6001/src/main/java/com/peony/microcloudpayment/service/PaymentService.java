package com.peony.microcloudpayment.service;

import com.peony.entity.PaymentRequest;
import com.peony.microcloudpayment.thrid.PayApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 同步处理
 */
@Service
public class PaymentService {

    @Autowired
    private PayApi payApi;

    public String payment(PaymentRequest paymentRequest) throws InterruptedException {
        System.out.println("PROCESSING...");
        Thread.sleep(2000);
        return payApi.doPay(paymentRequest);
    }
}
