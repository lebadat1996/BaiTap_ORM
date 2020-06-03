package com.codegym.service;

import com.codegym.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService {
    @Override
    public List<Product> findAll() throws SQLException {
        return null;
    }

    @Override
    public void insertProduct(Product product) throws SQLException {

    }

    @Override
    public Product getProductById(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return false;
    }

    @Override
    public List<Product> searchProduct(String name) throws SQLException {
        return null;
    }
}
