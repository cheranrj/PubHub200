package com.cheran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheran.Repository.BookRepository;
import com.cheran.model.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> findByPriceDesc() {

		return bookRepository.findByOrderByPriceDesc();
	}

	public List<Book> findByPriceAsc() {

		return bookRepository.findByOrderByPriceAsc();
	}

	public List<Book> findByReleasedDateDesc() {

		return bookRepository.findByOrderByReleasedDateDesc();
	}

	public List<Book> findAll() {

		return bookRepository.findAll();
	}

	public Book findOne(Long id) {

		return bookRepository.findOne(id);
	}

}
