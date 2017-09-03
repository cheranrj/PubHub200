package com.cheran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheran.Repository.OrderItemRepository;
import com.cheran.model.OrderItem;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	public void save(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}

}
