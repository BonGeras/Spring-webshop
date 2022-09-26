package com.example.springwebstore.Repository;

import com.example.springwebstore.Data.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
