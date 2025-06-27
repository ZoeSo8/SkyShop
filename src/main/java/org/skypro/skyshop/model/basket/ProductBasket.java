package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@SessionScope
@Component
public class ProductBasket {
    private final Map<UUID, Integer> productBasket;

    public ProductBasket() {
        this.productBasket = new HashMap<>();
    }
    public void addProduct (UUID product){
        if (productBasket.containsKey(product)) {
            productBasket.put(product, productBasket.get(product) + 1);
        }else {
            productBasket.put(product,1);
        }
    }

    public Map<UUID,Integer> getAllProductBasket(){
        return Collections.unmodifiableMap(productBasket);
    }
}
