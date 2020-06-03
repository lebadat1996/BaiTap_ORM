package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.repositories.HibernateProductRepositories;
import com.codegym.repositories.IProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    IProductRepositories productRepositories = new HibernateProductRepositories();

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("product", productRepositories.getAllProduct());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView ShowCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("home");
        int size = productRepositories.getAllProduct().size();
        size++;
        product.setId(size);
        productRepositories.insertProduct(product);
        modelAndView.addObject("product", productRepositories.getAllProduct());
        return modelAndView;
    }
}
