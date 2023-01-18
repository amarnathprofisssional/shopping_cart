package com.test.cart.controller;

import com.test.cart.handler.CustomerHandler;
import com.test.cart.service.CustomerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController {
    @Autowired
    private CustomerFactory customerFactory;

    @RequestMapping("/billing/{customerType}/{amount}")
    public float processBilling(
            @PathVariable("customerType") String customerType,
            @PathVariable("amount") float amount){
        CustomerHandler customer = customerFactory.fetchCustomerHandler(customerType);
        return customer.processBillAmount(amount);
    }
}
