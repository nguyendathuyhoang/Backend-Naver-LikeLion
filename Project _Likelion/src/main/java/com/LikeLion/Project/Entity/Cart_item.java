package com.LikeLion.Project.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "CART_ITEM")
public class Cart_item {
    @Id
    @GeneratedValue
    @Column(name = "cart_id", nullable = false)
    private int cart_id;

    @Column(name = "product_id", nullable = false)
    private int product_id;

    @Column(name = "quantity_wished", nullable = false)
    private int quantity_wished;

    @Column(name = "date_added", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date_added;

    @Column(name = "total_amount", nullable = false)
    private Double total_amount;

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity_wished() {
        return quantity_wished;
    }

    public void setQuantity_wished(int quantity_wished) {
        this.quantity_wished = quantity_wished;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }
}
