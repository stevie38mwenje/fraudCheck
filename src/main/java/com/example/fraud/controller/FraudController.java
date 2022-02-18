package com.example.fraud.controller;


import com.example.fraud.dto.FraudCheckResponse;
import com.example.fraud.service.FraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckService fraudCheckService) {

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        log.info("CHECKING FRAUD FOR CUSTOMER ID {}", customerId);
        boolean isFraudulentCustomer = fraudCheckService.isFraudulent(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
