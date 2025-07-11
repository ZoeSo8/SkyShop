package org.skypro.skyshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;

import java.util.*;

import static javax.swing.text.html.HTML.Tag.U;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    @Mock
    private ProductBasket productBasket;
    @Mock
    private StorageService storageService;
    @InjectMocks
    private BasketService basketService;

    @Test
    public void addProduct_nonExistentProduct_throwsException(){
        UUID nonExistentProductId = UUID.randomUUID();
        when(storageService.getProductById(nonExistentProductId)).thenReturn(Optional.empty());

        assertThrows(NoSuchProductException.class, () ->basketService.addProductInBasketToId(nonExistentProductId));
    }
    @Test
    public void addProduct_existentProduct_callsAddProductOnProductBasket(){
        UUID existentProductId = UUID.randomUUID();
        Product product = new SimpleProduct("Test Product", existentProductId, 88);
        when(storageService.getProductById(existentProductId)).thenReturn(Optional.of(product));

        basketService.addProductInBasketToId(existentProductId);
        verify(productBasket).addProduct(existentProductId);
    }
    @Test
    public void getUserBasket_WhenEmpty_ReturnsEmptyBasket() {
        when(productBasket.getAllProductBasket()).thenReturn(Map.of());
        UserBasket userBasket = basketService.getUserBasket();
        Assertions.assertEquals(0,userBasket.getBasketItem().size());
    }

    @Test
    public void getUserBasket_productBasketWithItems_returnsCorrectBasket(){
        UUID productId1 = UUID.randomUUID();
        UUID productId2 = UUID.randomUUID();
        Product product1 = new SimpleProduct("Test Product1",productId1,55);
        Product product2 = new SimpleProduct("Test Product2",productId2,555);
        Map<UUID,Integer> basketMap = new HashMap<>();
        basketMap.put(productId1,2);
        basketMap.put(productId2,1);

    }
}
