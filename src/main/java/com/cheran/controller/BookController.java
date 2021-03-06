package com.cheran.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cheran.model.Book;
import com.cheran.service.BookService;

@Controller
@RequestMapping("books")
public class BookController {

	private static final Logger LOGGER = Logger.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@GetMapping
	public String list(@RequestParam(value = "price", required = false) String priceFilter,
			@RequestParam(value = "releasedDate", required = false) String releasedDateFilter, HttpSession session) {

		LOGGER.info("List of Books");

		List<Book> books = null;

		if (priceFilter != null) {
			if (priceFilter.equals("desc")) {
				books = bookService.findByPriceDesc();
			} else if (priceFilter.equals("asc")) {
				books = bookService.findByPriceAsc();
			}
		} else if (releasedDateFilter != null) {
			if (releasedDateFilter.equals("desc")) {
				books = bookService.findByReleasedDateDesc();
			}
		} else {
			books = bookService.findAll();
		}
		System.out.println(books);
		session.setAttribute("books", books);
		return "book/list";

	}

	@GetMapping("/{id}")
	public String viewDetials(@PathVariable("id") Long id, HttpSession session, ModelMap modelMap) {
		Book book = bookService.findOne(id);
		modelMap.addAttribute("SELECTED_BOOK", book);
		// session.setAttribute("SELECTED_BOOK", id);
		return "book/show";
	}

}
