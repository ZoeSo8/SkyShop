package org.skypro.skyshop.controller;

package org.skypro.skyshop.service.StorageService;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;

import java.util.Collection;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public record ShopController() {
    private final StorageService storageService;
    private final SearchService searchService;

    public ShopController(StorageService storageService, SearchService searchService) {
        this.storageService = storageService;
        this.searchService = searchService;
    }

    @GetMapping("/product")
    public Collection <Product> getAllProduct(){
        return storageService.getAllProducts();
    }
    @GetMapping ("/articles")
public Collection <Article> getAllArticles (){
        return storageService.getAllArticles();
    }
    @GetMapping("/search")
    public Collection<SearchResult> search(@RequestParam("pattern")String pattern){
        return searchService.search(pattern);
    }
}
