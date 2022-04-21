package com.ait.mapper;


import com.ait.entry.BookBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BooksRepository extends JpaRepository<BookBooks, Integer> {

}

