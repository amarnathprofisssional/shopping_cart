package com.test.cart.pojo;

public class SlabDefinition {
    private float fromAmt;
    private float toAmt;
    private float discount;

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getFromAmt() {
        return fromAmt;
    }

    public void setFromAmt(float fromAmt) {
        this.fromAmt = fromAmt;
    }

    public float getToAmt() {
        return toAmt;
    }

    public void setToAmt(float toAmt) {
        this.toAmt = toAmt;
    }

    public SlabDefinition(float fromAmt, float toAmt, float discount) {
        this.fromAmt = fromAmt;
        this.toAmt = toAmt;
        this.discount = discount;
    }
}
