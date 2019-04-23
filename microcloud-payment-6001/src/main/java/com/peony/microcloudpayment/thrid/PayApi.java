package com.peony.microcloudpayment.thrid;

import com.peony.entity.PaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class PayApi {

    public String doPay(PaymentRequest paymentRequest){
        System.out.println("PAY SUCCESS");
        return "SUCCESS";
    }
}
