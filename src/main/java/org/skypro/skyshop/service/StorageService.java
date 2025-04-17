package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;

    public StorageService() {
        this.productStorage = new TreeMap<>();
        this.articleStorage = new TreeMap<>();
        addProductArticle();

    }

    public Collection<Article> getAllArticles() {
        return articleStorage.values();
    }

    public Optional<Article> getArticleById(UUID id) {
        return Optional.ofNullable(articleStorage.get(id));
    }

    public Collection<Product> getAllProducts() {
        return productStorage.values();
    }

    public Optional<Product> getProductById(UUID id) {

        return Optional.ofNullable(productStorage.get(id));}

    public Collection<Searchable> getSearchableItems() {
        List<Searchable> searchableItems = new ArrayList<>();
        searchableItems.addAll(this.productStorage.values());
        searchableItems.addAll(this.articleStorage.values());
        return searchableItems;
    }

    private void addProductArticle() {


        Product pen = new SimpleProduct("Ручка", UUID.randomUUID(), 100);
        Product book = new SimpleProduct("Книга", UUID.randomUUID(), 500);
        Product box = new SimpleProduct("Коробка", UUID.randomUUID(), 200);
        Product sticker = new SimpleProduct("Стикер", UUID.randomUUID(), 150);
        Product pencil = new SimpleProduct("Карандаш", UUID.randomUUID(), 50);
        Product marker = new SimpleProduct("Маркер", UUID.randomUUID(), 300);
        Product slimeFix = new FixPriceProduct("Слайм", UUID.randomUUID());
        Product penDiscount = new DiscountedProduct(pen.getName(), UUID.randomUUID(), 100, 20);
        this.productStorage.put(pen.getId(), pen);
        this.productStorage.put(book.getId(), book);
        this.productStorage.put(sticker.getId(), sticker);


        Article penDescribe = new Article("Описание ручки", "Гелевая черная", UUID.randomUUID());
        Article pencilDescribe = new Article("Описание карандаш", "Меловой синий", UUID.randomUUID());
        Article boxDescribe = new Article("Описание коробки", "Малая подарочная", UUID.randomUUID());
        Article markerDescribe = new Article("Описание маркер", "Широкий синий", UUID.randomUUID());
        this.articleStorage.put(pencilDescribe.getId(), pencilDescribe);
    }
}
