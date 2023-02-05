package com.galvanize.datavalidation.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("orders")
public class OrderEntity {

    // OrderEntity is based on OrderModel
    // Purpose is to connect OrderModel to the database

    @Id
    @Column("ID")
    Long id;

    @Column("ORDER_NUMBER")
    String orderNo;

    @Column("PRODUCT_NAME")
    String productName;

    @Column("PRICE")
    float price;

    @Column("QTY")
    int quantity;

    // need no args constructor for Spring Data JPA
    public OrderEntity() {}

    public OrderEntity(Long id, String orderNo, String productName, float price, int quantity) {
        super();
        this.id = id;
        this.orderNo = orderNo;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
