package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.model.Books;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBookListService;

@Controller
public class MyAvailableBooksController {
	@Autowired
	private MyBookListService service1;
	@Autowired
	private BookService service;
	@RequestMapping("/deleteMyBooks/{id}")
	public String delteteMyBooks(@PathVariable("id") int id) {
		service.deleteById(id);
		service1.deleteById(id);
		return "redirect:/availablebooks";		
	}
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Books b = service.getBookById(id);
		model.addAttribute("book",b);
		return "editbook"; 
		
	}
}
