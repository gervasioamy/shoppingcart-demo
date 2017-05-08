package com.globant.challenge.domain;

import java.math.BigDecimal;

/**
 * Article representation
 *
 * @author gervasio.amy
 */
public class Article {

    private String id;

    private String title;

    private Number price;

    public Article() {}

    public Article(String id, String title, Number price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }
}
