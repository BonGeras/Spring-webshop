package com.example.springwebstore.Repository;

import com.example.springwebstore.Data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
