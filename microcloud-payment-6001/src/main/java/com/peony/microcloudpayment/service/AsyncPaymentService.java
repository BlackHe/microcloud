package com.peony.microcloudpayment.service;

import com.peony.entity.PaymentRequest;
import com.peony.microcloudpayment.thrid.PayApi;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 异步处理
 */
@Service()
public class AsyncPaymentService{

    public AsyncPaymentService() {
        this.init();
    }
    private static LinkedBlockingQueue<PaymentRequest> paymentRequests = new LinkedBlockingQueue<>();

    @Autowired
    private PayApi payApi;

    public String payment(PaymentRequest paymentRequest) throws InterruptedException {
        paymentRequests.add(paymentRequest);
        return "PROCESSING";
    }



    private void init(){
        System.out.println("AsyncPaymentService init()");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        PaymentRequest paymentRequest = paymentRequests.take();
                        payApi.doPay(paymentRequest);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
