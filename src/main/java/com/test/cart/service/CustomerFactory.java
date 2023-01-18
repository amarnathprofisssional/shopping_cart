package com.test.cart.service;

import com.test.cart.handler.CustomerHandler;
import com.test.cart.handler.impl.PremiumHandler;
import com.test.cart.handler.impl.RegularHandler;
import com.test.cart.pojo.CustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerFactory {
    @Autowired
    private PremiumHandler premiumHandler;
    @Autowired
    private RegularHandler regularHandler;
    public CustomerHandler fetchCustomerHandler(String customerType){
        if(customerType.equals(CustomerType.PREMIUM.name())){
            return premiumHandler;
        }else if (customerType.equals(CustomerType.REGULAR.name())){
            return regularHandler;
        }
        return null;
    }
}
