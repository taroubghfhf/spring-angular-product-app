package com.product.uq.controller;

import com.product.uq.model.product.Product;
import com.product.uq.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin(origins = "*") // permite que el frontend consuma la API
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
   @GetMapping
    public List<Product> list() {
        return productService.listProduct();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getIdProduct(id);
    }

    @PostMapping
    public Product postProduct(@RequestBody Product product) {
        return productService.postProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProdut(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boolean delete = productService.deleteProduct(id);
        return delete ? "Producto eliminado" : "No se encontró el producto";
    }
}
