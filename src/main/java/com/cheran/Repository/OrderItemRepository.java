package com.cheran.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheran.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
