package com.ait.controller;

import com.ait.entry.BookBooks;
import com.ait.entry.SaleOrder;
import com.ait.exception.booksNotFoundException;
import com.ait.mapper.BooksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@ResponseBody
@RequestMapping("/sc_book")



public class BooksController {
    @Autowired
    BooksRepository booksRepository;

    @Autowired
    private OrderFeign orderFeign;


    // @GetMapping("/getAll")
    // public ResponseEntity queryStudent(){
    //     List<BookBooks> list ;
    //    list = booksRepository.findAll();
    //    return ResponseEntity.ok(list);
    // }

    @GetMapping("/books")
    List<BookBooks> getauthorityEntity() {
        return booksRepository.findAll();
    }


    //2.更新
    @RequestMapping("/books/{id}")
    Optional<BookBooks> getProduct(@PathVariable("id") Integer id) {



        Optional<BookBooks> books = booksRepository.findById(id);
        if (books.isPresent()) {
            return books;
        } else {
            throw new booksNotFoundException("NO authoritys with id" + id);
        }
    }


    //3.添加delete
    @DeleteMapping("/books/{id}")
    void deleteWineById(@PathVariable Integer id){

        Optional<BookBooks> books = booksRepository.findById(id);
        if (books.isPresent()) {
            BookBooks existingAuthoritys =books.get();
            booksRepository.delete(existingAuthoritys);
        } else {
            throw new booksNotFoundException("NO authoritys with id" + id);
        }
    }

    @PostMapping("/insertOrder")
    ResponseEntity createWine(@RequestBody SaleOrder saleOrder){

        Integer booktId = saleOrder.getBooktId();

        Optional<BookBooks> books = booksRepository.findById(booktId);

        BigDecimal orderPrice = books.get().getPrice().multiply(new BigDecimal(saleOrder.getBookNum()));
        saleOrder.setOrderAmount(orderPrice);

        orderFeign.insertOrder(saleOrder);

        return ResponseEntity.ok(saleOrder) ;

    }

    //5.添加update
    @PutMapping("books/{id}")
    public ResponseEntity updatewine(@PathVariable("id") Integer id,@RequestBody BookBooks bookBooks){

        Optional<BookBooks> savedwine = booksRepository.findById(id);
        if (savedwine.isPresent()) {
            booksRepository.save(bookBooks);

            return ResponseEntity.status(HttpStatus.OK).body(bookBooks);

        } else {
            throw new booksNotFoundException("NO authoritys with id" + id);
        }


    }

}





