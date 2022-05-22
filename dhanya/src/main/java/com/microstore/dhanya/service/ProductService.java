package com.microstore.dhanya.service;

import com.microstore.dhanya.model.Product;
import com.microstore.dhanya.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product getProductById(Integer productId)
    {
        return repository.findProductById(productId);
    }
}
