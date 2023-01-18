package com.test.cart.handler.impl;

import com.test.cart.handler.CustomerHandler;
import com.test.cart.pojo.SlabDefinition;
import com.test.cart.service.CustomerBillingProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegularHandler implements CustomerHandler {
    @Autowired
    private CustomerBillingProcessing billingProcessing;
    private List<SlabDefinition> slabDetails = new ArrayList<>();
    public RegularHandler() {
        SlabDefinition s1 = new SlabDefinition(0,5000,0);
        SlabDefinition s2 = new SlabDefinition(5000,10000,0.1f);
        SlabDefinition s3 = new SlabDefinition(10000,Integer.MAX_VALUE,0.2f);
        slabDetails.add(s1);
        slabDetails.add(s2);
        slabDetails.add(s3);
    }
    @Override
    public float processBillAmount(float amount) {
        List<SlabDefinition> slabsRequired = billingProcessing.fetchSlabsAssociated(amount, slabDetails);
        return billingProcessing.processSlab(amount,slabsRequired);
    }
}
