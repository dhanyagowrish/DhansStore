package com.microstore.dhanya.repository;

import com.microstore.dhanya.model.CartItem;
import com.microstore.dhanya.model.Product;
import com.microstore.dhanya.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    public CartItem findByUserAndProduct(User user, Product product);
    public void deleteByUserAndProduct(User user, Product product);

    public List<CartItem> findAllByUserOrderByQuantity(User user);
}
