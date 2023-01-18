package com.test.cart.service;

import com.test.cart.pojo.SlabDefinition;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerBillingProcessing {
    public List<SlabDefinition> fetchSlabsAssociated(float amount, List<SlabDefinition> slabDetails){
        return slabDetails.stream().filter(slab ->
                ((amount<=slab.getToAmt() && amount>slab.getFromAmt()) || (amount>slab.getToAmt()))).
                collect(Collectors.toList());
    }

    public float processSlab(float amount, List<SlabDefinition> slabDetails){
        float discountAmt =0;
        float actualAmt = amount;
        for (SlabDefinition slab: slabDetails) {
            float fromAmt = slab.getFromAmt();
            float toAmt = slab.getToAmt();
            float discount = slab.getDiscount();
            float diffAmt = toAmt - fromAmt;
            float remainAmt = amount - diffAmt;
            float subAmt = 0;
            if(remainAmt>0){
                amount = remainAmt;
                subAmt = diffAmt;
            }else if(remainAmt<=0){
                subAmt = amount;
            }
            discountAmt = discountAmt + subAmt*discount;
        }
        return actualAmt - discountAmt;
    }
}
