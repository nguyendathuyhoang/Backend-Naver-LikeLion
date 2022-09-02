package com.LikeLion.Project.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@Data
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id", nullable = false)
    private int product_id;

    @Column(name = "name_product", nullable = false)
    private String name_product;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "price", nullable = false)
    private Double price;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
