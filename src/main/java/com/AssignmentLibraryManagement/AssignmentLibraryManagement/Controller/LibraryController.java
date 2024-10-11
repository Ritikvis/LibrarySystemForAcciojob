package com.AssignmentLibraryManagement.AssignmentLibraryManagement.Controller;

import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Book;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Librarian;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Library;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Member;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository.LibraryRepository;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Library")
public class LibraryController {
    
    @Autowired
    private LibraryService libraryService;
    
    
    @PostMapping("addLibrary")
    public ResponseEntity<Library> AddLibrary(@RequestBody Library library){
        Library library1 = libraryService.AddLibrary(library);
        return new ResponseEntity<>(library1,HttpStatus.CREATED);
    }

    @GetMapping("list-Of-Librarians/{libraryId}")
    public ResponseEntity<List<Librarian>> ListOfLibrarian(@PathVariable Long libraryId){
        List<Librarian> librarians = libraryService.ListOfLibrarian(libraryId);
        return new ResponseEntity<>(librarians, HttpStatus.CREATED);
    }
    @PostMapping("addLibrarianToLibrary")
    public ResponseEntity<Void> AddLibrarianToLibrary(@RequestParam Long libraryId,@RequestParam Long librarianId ){
        libraryService.AddLibrarianToLibrary(libraryId,librarianId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("list-Of-Member/{libraryId}")
    public ResponseEntity<List<Member>> ListOfMember(@PathVariable Long libraryId){
        List<Member> members = libraryService.ListOfMember(libraryId);
        return new ResponseEntity<>(members, HttpStatus.CREATED);
    }
    @GetMapping("availableBooks/{libraryId}")
    public ResponseEntity<List<Book>> getAvailableBooks(@PathVariable Long libraryId) {
        List<Book> availableBooks = libraryService.getAvailableBooks(libraryId);
        return new ResponseEntity<>(availableBooks, HttpStatus.OK);
    }


}
