package com.example.springwebstore.Service;

import com.example.springwebstore.Data.Order;

public interface OrderService {
    void saveOrder(Order order);

    Order getOrder(Long id);
}
