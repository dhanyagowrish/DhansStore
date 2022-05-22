package com.microstore.dhanya.model;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "price")
    private Integer price;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Product(String name, Integer price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
