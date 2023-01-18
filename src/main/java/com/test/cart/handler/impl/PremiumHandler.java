package com.test.cart.handler.impl;

import com.test.cart.handler.CustomerHandler;
import com.test.cart.pojo.SlabDefinition;
import com.test.cart.service.CustomerBillingProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PremiumHandler implements CustomerHandler {

    @Autowired
    private CustomerBillingProcessing billingProcessing;

    private List<SlabDefinition> slabDetails = new ArrayList<>();

    public PremiumHandler() {
        SlabDefinition s1 = new SlabDefinition(0,4000,0.1f);
        SlabDefinition s2 = new SlabDefinition(4000,8000,0.15f);
        SlabDefinition s3 = new SlabDefinition(8000,12000,0.2f);
        SlabDefinition s4 = new SlabDefinition(12000,Integer.MAX_VALUE,0.3f);
        slabDetails.add(s1);
        slabDetails.add(s2);
        slabDetails.add(s3);
        slabDetails.add(s4);
    }

    @Override
    public float processBillAmount(float amount) {
        List<SlabDefinition> slabsRequired = billingProcessing.fetchSlabsAssociated(amount, slabDetails);
        return billingProcessing.processSlab(amount,slabsRequired);
    }

}
