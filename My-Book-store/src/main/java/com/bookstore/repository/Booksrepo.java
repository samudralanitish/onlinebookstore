package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Books;
@Repository
public interface Booksrepo extends JpaRepository<Books, Integer>{

}
