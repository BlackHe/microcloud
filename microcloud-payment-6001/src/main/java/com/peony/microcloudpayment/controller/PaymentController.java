package com.peony.microcloudpayment.controller;

import com.peony.entity.PaymentRequest;
import com.peony.microcloudpayment.service.AsyncPaymentService;
import com.peony.microcloudpayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 内部支付处理
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private AsyncPaymentService asyncPaymentService;

    @PostMapping("/sync/{amount}")
    public String paymentSync(BigDecimal amount){
        try {
            Long start = System.currentTimeMillis();
            String result = paymentService.payment(new PaymentRequest(amount));
            System.out.println("sync payment time cost is : " + (System.currentTimeMillis()-start));
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/async/{amount}")
    public String paymentAsync(BigDecimal amount){
        try {
            Long start = System.currentTimeMillis();
            String result = asyncPaymentService.payment(new PaymentRequest(amount));
            System.out.println("async payment time cost is : " + (System.currentTimeMillis()-start));
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
