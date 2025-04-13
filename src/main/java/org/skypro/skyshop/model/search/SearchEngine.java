package org.skypro.skyshop.model.search;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> items;
    private int count;

    public SearchEngine() {
        this.items = new HashSet<>();
        count = 0;
    }

    public void add(Searchable item) {
        if (count < items.size()) {
            items.add(item);
            count++;
        } else {
            System.out.println("Массив заполнен. Невозможно добавить новый элемент.");
        }
    }


            }




