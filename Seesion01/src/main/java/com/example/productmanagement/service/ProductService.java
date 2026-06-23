package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> productList = new ArrayList<>();

    public ProductService() {
        productList.add(new Product(1, "Laptop Dell", 1500.0));
        productList.add(new Product(2, "Iphone 15", 1200.0));
        productList.add(new Product(3, "Chuột Logitech", 25.0));
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public boolean updateProduct(int id, Product updatedProduct) {
        for (Product product : productList) {
            if (product.getId() == id) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        return productList.removeIf(product -> product.getId() == id);
    }
}
