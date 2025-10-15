package com.product.uq.service;

import com.product.uq.model.product.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        // Datos quemados
        products.add(new Product(1L, "Laptop Lenovo", 2500000, "Tecnología"));
        products.add(new Product(2L, "Celular Samsung", 1800000, "Tecnología"));
        products.add(new Product(3L, "Camisa Blanca", 75000, "Ropa"));
        products.add(new Product(4L, "Cafetera", 230000, "Electrodoméstico"));
    }

    public List<Product> listProduct() {
        return products;
    }


    public Product getIdProduct(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product postProduct(Product product) {
        product.setId((long) (products.size() + 1));
        products.add(product);
        return product;
    }

    public Product updateProduct(Long id, Product updateProduct) {
        Optional<Product> optional = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (optional.isPresent()) {
            Product existing = optional.get();
            existing.setName(updateProduct.getName());
            existing.setPrice(updateProduct.getPrice());
            existing.setCategory(updateProduct.getCategory());
            return existing;
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}

