package com.globant.challenge.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * An item in the shopping cart.
 *
 * @author gervasio.amy
 */
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String reference;

    private Integer quantity;

    public Item() {}

    public Item(Long id, String reference, Integer quantity) {
        this.id = id;
        this.reference = reference;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
