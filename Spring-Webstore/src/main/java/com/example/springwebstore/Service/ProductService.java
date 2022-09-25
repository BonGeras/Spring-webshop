package com.example.springwebstore.Service;

import com.example.springwebstore.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();

    void addToUserBucket(Long productId, String username);

    void removeFromUserBucket(Long productId, String username);
}
