package com.microstore.dhanya.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

   @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;



    /*@ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    //@JsonIgnore
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    //@JoinColumn(nullable = false, name = "user_id")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
*/

    @Column(name = "quantity")
    private Integer quantity;


    public CartItem(User user, Product product, Integer quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString()
    {
        return this.quantity + " " + this.id + " " + this.user.getEmail() + " " + this.product.getName();
    }
}
