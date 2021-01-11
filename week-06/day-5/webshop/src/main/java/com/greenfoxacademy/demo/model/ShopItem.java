package com.greenfoxacademy.demo.model;

public class ShopItem {
    private String name;
    private String description;
    private Double price;
    private Integer quantityOfStock;
    private String currency = "mari";

    public ShopItem(String name, String description, Double price, Integer quantityOfStock, String currency) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityOfStock = quantityOfStock;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantityOfStock() {
        return quantityOfStock;
    }

    public void setQuantityOfStock(Integer quantityOfStock) {
        this.quantityOfStock = quantityOfStock;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

