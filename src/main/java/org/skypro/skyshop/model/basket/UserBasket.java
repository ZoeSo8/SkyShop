package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> basketItem;
    public int totalPrise;

    public UserBasket(List<BasketItem> basketItem) {
        this.basketItem = basketItem;
        this.totalPrise = basketItem.stream().mapToInt(i->i.getProduct().getPrice()*i.getQuantity()).sum();
    }

    public List<BasketItem> getBasketItem(){ return basketItem;}
    public int getTotalPrise(){return totalPrise;}
    }
