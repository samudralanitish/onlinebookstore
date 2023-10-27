package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.model.Books;
import com.bookstore.model.MyBookList;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBookListService;


@Controller
public class MainController {
	@Autowired
	private BookService service;
	@Autowired
	MyBookListService booklistservice;
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@GetMapping("/availablebooks")
	public ModelAndView getallbooks() {
		List<Books>list=service.getallbooks();
		return new ModelAndView("availablebooks","book",list);
	}
	
	@GetMapping("/mybooks")
	public String mybooks(Model model) {
		List<MyBookList>list=booklistservice.getAllMyBooks();
		model.addAttribute("book",list);
		return "mybooks";
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute Books b) {
		service.save(b);
		return "redirect:/availablebooks";
	}
	
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id")int id) {
		Books b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getBookname(),b.getAuthorname(),b.getPrice());
		booklistservice.getBookList(mb);
		return "redirect:/mybooks";
		
	}
	
}
