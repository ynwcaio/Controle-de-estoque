package com.api.products.DTO;

import com.api.products.model.entities.Product;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String name;
    private String type;
    private Integer quantity;
    private BigDecimal price;


    public ProductDTO(){

    }

    public ProductDTO(Product products){
        this.id = products.getId();
        this.name = products.getName();
        this.type = products.getType();
        this.quantity = products.getQuantity();
        this.price = products.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
