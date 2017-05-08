package com.globant.challenge.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gervasio.amy
 */
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    @Transient
    private Number totalPrice;

    public void addItem(Item item) {
        items.add(item);
    }

    private boolean removeItem(Item item) {
        return this.items.remove(item);
    }

    public void clearItems() {
        this.items = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Number getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Number totalPrice) {
        this.totalPrice = totalPrice;
    }
}
