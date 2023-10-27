package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.MyBookList;
import com.bookstore.repository.BookListrepo;
@Service
public class MyBookListService {
	@Autowired
	BookListrepo repo;
	
	
	public void getBookList(MyBookList book) {
		repo.save(book);
	}
	public List<MyBookList>getAllMyBooks(){
		return repo.findAll();
	}
	public void deleteById(int id) {
		repo.deleteById(id);
	}
}
