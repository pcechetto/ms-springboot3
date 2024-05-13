package com.example.hrpayroll.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.entities.Worker;
import com.example.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    @SuppressWarnings("null")
    public Payment getPayment(long workerId, int days) {
        
        Optional<Worker> worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.get().getName(), worker.get().getDailyIncome(), days);
    }

}
