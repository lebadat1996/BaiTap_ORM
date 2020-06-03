package com.codegym.repositories;

import com.codegym.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class HibernateProductRepositories implements IProductRepositories {
    SessionFactory sessionFactory;
    EntityManager entityManager;


    public HibernateProductRepositories() {
        this.sessionFactory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
        this.entityManager = sessionFactory.createEntityManager();
    }

    @Override
    public List<Product> getAllProduct() {
        String query = "SELECT p from Product p";
        return this.entityManager.createQuery(query, Product.class).getResultList();
    }


    @Override
    public void insertProduct(Product product) {
        if (Long.valueOf(product.getId()) != null) {
            entityManager.merge(product);
        } else {
            entityManager.persist(product);
        }
    }
}
