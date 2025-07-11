package org.skypro.skyshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @Mock
    private StorageService storageService;
    @InjectMocks
    private SearchService searchService;


    @Test
    public void givenEmptyStorage_whenFind_thenReturnEmptyList() {
        when(storageService.getSearchableItems()).thenReturn(Collections.emptyList());
        Assertions.assertEquals(Collections.emptyList(), searchService.search("Объектов нет"));
    }
    @Test
    public void givenNonCorrectStorage_whenFind_thenReturnCorrectList(){
        UUID productId1 = UUID.randomUUID();
        UUID productId2 = UUID.randomUUID();
        Product product1 = new SimpleProduct("Test Product1",productId1,55);
        Product product2 = new SimpleProduct("Test Product2",productId2,555);
        when(storageService.getSearchableItems()).thenReturn(List.of(product1,product2));
        Assertions.assertEquals(Collections.emptyList(), searchService.search("Блокнот"));
    }
    @Test
    public void givenCorrectStorage_whenFind_thenReturnCorrectList(){
        UUID productId1 = UUID.randomUUID();
        UUID productId2 = UUID.randomUUID();
        UUID productId3 = UUID.randomUUID();
        Product product1 = new SimpleProduct("Ручка",productId1,55);
        Product product2 = new SimpleProduct("Перо",productId2,555);
        Product product3 = new SimpleProduct("Ручка",productId3,888);
        when(storageService.getSearchableItems()).thenReturn(List.of(product1,product2,product3));
        List<SearchResult> result = searchService.search("Ручка");

        Assertions.assertEquals(2, result.size());
        Assertions.assertFalse(result.contains(product1));
        Assertions.assertFalse(result.contains(product3));
    }


}


//    //Поиск в случае отсутствия объектов в
//    //StorageService
//    //.
//    //Поиск в случае, если объекты в
//    //StorageService
//    // есть, но нет подходящего.
//    //Поиск, когда есть подходящий объект в

