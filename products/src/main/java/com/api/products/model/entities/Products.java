package com.api.products.model.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "tb_products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price" , precision = 10, scale = 2)
    private BigDecimal price;

    public Products(){

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
