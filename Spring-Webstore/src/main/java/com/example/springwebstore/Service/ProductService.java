package com.example.springwebstore.Service;

import com.example.springwebstore.DTO.ProductDTO;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();

    void addToUserBucket(Long productId, String username);

    void addProduct(ProductDTO dto);

    ProductDTO getById(Long id);

    void removeFromUserBucket(Long productId, String username);
}
