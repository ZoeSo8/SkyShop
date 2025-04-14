package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public abstract class Product implements Searchable {
    private String namedAbs;
    private final UUID id;

    public Product(String namedAbs, UUID id) {
        if (isStringNullOrBlank(namedAbs)) {
            throw new IllegalArgumentException("Наименование не может быть пустым");
        }
        this.namedAbs = namedAbs;
        this.id = id;
    }

    private boolean isStringNullOrBlank(String namedAbs) {
        return namedAbs == null || namedAbs.isBlank();
    }

    public String getName() {
        return this.namedAbs;
    }

    public abstract int getPrice();


    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Наименование " + this.namedAbs;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(namedAbs);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Product c2 = (Product) other;
        return namedAbs.equals(c2.namedAbs);
    }

    public abstract boolean isSpecial();


    @Override
    @JsonIgnore
    public String gettingContentType() {
        return "PRODUCT";
    }

    @Override
    @JsonIgnore
    public String getSearchTerm() {
        return namedAbs;
    }
}



