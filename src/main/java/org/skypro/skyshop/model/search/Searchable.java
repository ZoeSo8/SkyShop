package org.skypro.skyshop.model.search;

import org.skypro.skyshop.model.product.Product;

import java.util.Collection;
import java.util.UUID;

public interface Searchable {
    String searchTerm ();
    String gettingContentType ();

    default String getStringRepresentation(){
        return this.getClass().getSimpleName()+" - "+gettingContentType();
    }


    boolean containsKey(String query);

    boolean containsValue(Product query);

    Collection<Object> getSearchTerm();
    UUID getId();

}
