package com.edureka.bookms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BookController{
    @Autowired
    private BookService bookService;


    @PostMapping("/books")
    public ResponseEntity<String> saveBook(@RequestBody Book book){
        bookService.saveBook(book);
        return ResponseEntity.ok().body("Okay");
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> findAllbooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }


    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().body("Deleted Book");
    }


    @GetMapping("/book/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Integer id){
        return ResponseEntity.ok(bookService.getBookId(id));
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id,@RequestBody Book book){
        bookService.updateBoook(book);
        return ResponseEntity.ok().body("Updated Successsfully");
    }





}
