package com.codegym.repositories;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepositories {
    List<Product> getAllProduct();
    void insertProduct(Product product);
}
