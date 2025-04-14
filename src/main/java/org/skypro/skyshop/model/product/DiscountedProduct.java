package org.skypro.skyshop.model.product;

import java.util.Objects;
import java.util.UUID;

public class DiscountedProduct extends Product {
    private int basePrice;
    private double discountPricePercent;
    private double discountPrice;

    public DiscountedProduct(String namedAbs, UUID id,int basePrice, double discountPricePercent) {
        super(namedAbs,id);
        this.basePrice = basePrice;
        if (basePrice<=0) {
            throw new IllegalArgumentException("Цена должна быть строго больше 0");}
        this.discountPricePercent = (double) discountPricePercent;
        if (discountPricePercent<0 && discountPricePercent>100){
           throw  new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100%");}
    }
    @Override
    public int getPrice() {
        double discount = (basePrice*discountPricePercent)/100;
        return (int) (discountPrice =basePrice-discount);
    }

    @Override
    public String toString() {
        return this.getNamedAbs()+": стоимость "+this.getPrice() + " (скидка "+discountPricePercent+ "%)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return basePrice == that.basePrice && discountPricePercent == that.discountPricePercent && discountPrice == that.discountPrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basePrice, discountPricePercent, discountPrice);
    }
}

