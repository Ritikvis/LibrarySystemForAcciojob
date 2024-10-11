package com.AssignmentLibraryManagement.AssignmentLibraryManagement.Controller;

import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Book;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Book")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("addBook")
    public ResponseEntity<Book> AddBook(@RequestBody Book book){
        Book book1 = bookService.AddBook(book);
        return new ResponseEntity<>(book1, HttpStatus.CREATED);
    }
    @PostMapping("addBookToMember")
    public ResponseEntity<Void> AddBookToMember(@RequestParam Long bookId,@RequestParam Long memberId){
        bookService.AddBookToMember(bookId,memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("addBookToLibrary")
    public ResponseEntity<Void> AddBookToLibrary(@RequestParam Long bookId,@RequestParam Long libraryId){
        bookService.AddBookToLibrary(bookId,libraryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
