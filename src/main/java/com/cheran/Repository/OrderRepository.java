package com.cheran.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheran.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByUserIdOrderByIdDesc(Long userId);

	public List<Order> findByOrderByIdDesc();

}
