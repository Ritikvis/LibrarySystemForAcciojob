package com.AssignmentLibraryManagement.AssignmentLibraryManagement.Service;



import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Book;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Librarian;

import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Library;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Member;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository.LibrarianRepository;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private  LibrarianRepository librarianRepository;
    public List<Librarian> ListOfLibrarian(Long libraryId) {
        Library library = libraryRepository.findById(libraryId).
                orElseThrow(()-> new RuntimeException("Id not found : " +  libraryId));
        List<Librarian> librarians = library.getLibrarians();
        return librarians;
    }

    public Library AddLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public void AddLibrarianToLibrary(Long libraryId, Long librarianId) {
        Library library = libraryRepository.findById(libraryId).
                orElseThrow(()-> new RuntimeException("Id not found : " +  libraryId));
        Librarian librarian = librarianRepository.findById(librarianId)
                .orElseThrow(()-> new RuntimeException("Id not found : " +  librarianId));
        library.getLibrarians().add(librarian);
        librarian.getLibraries().add(library);
        libraryRepository.save(library);
    }

    public List<Member> ListOfMember(Long libraryId) {
        Library library = libraryRepository.findById(libraryId).
                orElseThrow(()-> new RuntimeException("Id not found : " +  libraryId));
        List<Member> members = library.getMembers();
        return members;
    }

    public List<Book> getAvailableBooks(Long libraryId) {
        Library library = libraryRepository.findById(libraryId)
                .orElseThrow(() -> new RuntimeException("Library not found: " + libraryId));

        List<Book> availableBooks = new ArrayList<>();

       for(Book book : library.getAvailableBooks()){
           if(book.getBorrowedBy()==null){
               availableBooks.add(book);
           }
       }

        return availableBooks;
    }
}
