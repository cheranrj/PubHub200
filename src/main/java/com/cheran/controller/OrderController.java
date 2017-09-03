package com.cheran.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cheran.model.Order;
import com.cheran.model.User;
import com.cheran.service.OrderService;
import com.cheran.service.UserService;

@Controller
@RequestMapping("orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	UserService userService;

	@GetMapping
	public String lists(ModelMap modelMap, HttpSession session) {

		List<Order> list = orderService.findAllOrders();
		System.out.println("orders:" + list.size());
		for (Order order : list) {
			System.out.println(order);
		}

		modelMap.addAttribute("ORDERS_LIST", list);

		return "order/list";

	}

	@GetMapping("/cart")
	public String cart() {

		return "order/cart";
	}

	@PostMapping("/save")
	public String save(@RequestParam("total_amount") Integer tamnt, @RequestParam("paymentmode") String payamnt,
			HttpSession session) {
		Order orderCart = (Order) session.getAttribute("MY_CART_ITEMS");
		User user = userService.findByEmail((String) session.getAttribute("logid"));

		if (orderCart != null && orderCart.getOrderItems().size() > 0) {

			System.out.println("user details" + user);

			orderCart.setUser(user);
			orderCart.setTotalPrice(tamnt);
			orderCart.setPaymentmode(payamnt);

			orderService.save(orderCart);
			session.removeAttribute("MY_CART_ITEMS");

		}
		return "redirect:../orders/myorders";

	}

	@GetMapping("/myorders")
	public String list(ModelMap modelMap, HttpSession session) {
		User user = userService.findByEmail((String) session.getAttribute("logid"));
		Long id = user.getId();
		List<Order> list = orderService.findByUserId(id);
		System.out.println("orders:" + list.size());
		for (Order order : list) {
			System.out.println(order);

		}
		modelMap.addAttribute("ORDERS_LIST", list);
		return "order/list";

	}

	@GetMapping("/updateStatus")
	public String updateStatus(@RequestParam("id") Long orderId, @RequestParam("status") String status) {
		Order order = orderService.findOne(orderId);
		if ("CANCELLED".equals(status)) {
			order.setCancelledDate(LocalDateTime.now());
		} else if ("DELIVERED".equals(status)) {
			order.setDeliveredDate(LocalDateTime.now());
		}

		order.setStatus(status);
		orderService.save(order);
		return "redirect:../orders";
	}

}
