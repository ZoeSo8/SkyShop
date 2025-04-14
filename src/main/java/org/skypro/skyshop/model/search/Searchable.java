package org.skypro.skyshop.model.search;

import org.skypro.skyshop.model.product.Product;

import java.util.Collection;
import java.util.UUID;

public interface Searchable {
    String gettingContentType ();
    String getSearchTerm();
    UUID getId();
    String getName();

}
