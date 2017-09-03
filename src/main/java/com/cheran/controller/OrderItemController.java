package com.cheran.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cheran.model.Book;
import com.cheran.model.Order;
import com.cheran.model.OrderItem;
import com.cheran.model.User;
import com.cheran.service.BookService;
import com.cheran.service.OrderService;

@Controller
@RequestMapping("orderItems")
public class OrderItemController {

	@Autowired
	BookService bookService;

	@Autowired
	OrderService orderService;

	@PostMapping("/addToCart")

	public String addToCart(@RequestParam("book_id") Long bookId, @RequestParam("qty") Integer qty,
			HttpSession session) {

		User user = (User) session.getAttribute("LOGGED_IN_USER");

		Order order = (Order) session.getAttribute("MY_CART_ITEMS");

		// create order
		if (order == null) {
			System.out.println("creating order");
			order = new Order();

			order.setUser(user);
			order.setTotalPrice(0);
			order.setStatus("ORDERED");
		}

		// store orderItems

		List<OrderItem> orderItems = order.getOrderItems();

		// If already the item is added to cart, then add the quantity

		boolean ifItemExists = false;
		for (OrderItem item : orderItems) {

			if (item.getBook().getId().equals(bookId)) {
				System.out.println("Adding the quantity");
				int totalQuantity = item.getQuantity() + qty;
				item.setQuantity(totalQuantity);
				ifItemExists = true;
			}
		}

		// If item not exists, create new Item
		if (!ifItemExists) {

			System.out.println("Creating new Item");
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);

			Book book = bookService.findOne(bookId);

			orderItem.setBook(book);
			orderItem.setQuantity(qty);
			orderItems.add(orderItem);
		}

		order.setOrderItems(orderItems);

		session.setAttribute("MY_CART_ITEMS", order);

		return "redirect:../orders/cart";
	}

	@GetMapping("/remove")
	public String removeItemFromCart(@RequestParam("id") Integer id, HttpSession session) {

		System.out.println("Item Removed from Card:" + id);
		Order order = (Order) session.getAttribute("MY_CART_ITEMS");

		if (order != null && order.getOrderItems().size() > 0) {
			List<OrderItem> orderItems = order.getOrderItems();
			OrderItem itemSelected = orderItems.get(id);
			orderItems.remove(itemSelected);
			order.setOrderItems(orderItems);
			session.setAttribute("MY_CART_ITEMS", order);
		}

		return "redirect:../orders/cart";

	}

}
