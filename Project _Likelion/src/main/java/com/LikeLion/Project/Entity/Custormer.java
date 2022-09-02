package com.LikeLion.Project.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CUSTORMER")
@Data
public class Custormer {
    @Id
    @GeneratedValue
    @Column(name = "customer_id", nullable = false)
    private int customer_id;

    @Column(name = "customer_name", nullable = false)
    private String customer_name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_no", nullable = false)
    private String phone_no;

    @Column(name = "cart_id", nullable = false)
    private int cart_id;
}
