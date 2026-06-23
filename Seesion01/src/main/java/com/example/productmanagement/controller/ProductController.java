package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "Thêm sản phẩm thành công!";
    }

    @PutMapping("/products/{id}")
    public String updateProducts(@PathVariable("id") int id, @RequestBody Product product) {
        boolean isUpdated = productService.updateProduct(id, product);
        if (isUpdated) {
            return "Cập nhật sản phẩm có ID " + id + " thành công!";
        }
        return "Không tìm thấy sản phẩm có ID " + id + " để cập nhật!";
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted) {
            return "Xóa sản phẩm có ID " + id + " thành công!";
        }
        return "Không tìm thấy sản phẩm có ID " + id + " để xóa!";
    }
}
