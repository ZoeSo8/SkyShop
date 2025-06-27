package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {

    private final String title;
    private final String text;
    private final UUID id;



    public Article(String title, String text, UUID id) {
        this.title = title;
        this.text = text;
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public String getText() {
        return text;
    }
    @Override
    public UUID getId() {return id;}

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String toString() {
        return "Название статьи: " + this.title+"\nТекст статьи: " + this.text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    @JsonIgnore
    public String gettingContentType() {
        return "ARTICLE";
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

   }


