package com.microstore.dhanya.repository;

import com.microstore.dhanya.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    public Product findProductById(Integer id);
}
