package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<SearchResult> search (String searchString){
        return this.storageService.getSearchableItems()
                .stream()
                .filter(searchable -> searchable.getSearchTerm().contains(searchString))
                .map(SearchResult::fromSearchable)
                .toList();
    }
}

