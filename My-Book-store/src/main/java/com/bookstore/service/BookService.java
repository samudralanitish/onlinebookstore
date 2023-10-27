package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.Books;
import com.bookstore.repository.Booksrepo;

@Service
public class BookService {

	@Autowired
	Booksrepo repo;
	
	public void save(Books b) {
		repo.save(b);
	}
	
	public List<Books>getallbooks(){
		return repo.findAll();
	}
	public Books getBookById(int id) {
		return repo.findById(id).get();
	}
	
	public void deleteById(int id) {
		repo.deleteById(id);
	}
}
