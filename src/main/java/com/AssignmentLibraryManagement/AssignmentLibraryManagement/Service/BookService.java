package com.AssignmentLibraryManagement.AssignmentLibraryManagement.Service;

import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Book;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Library;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Member;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository.BookRepository;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository.LibraryRepository;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private MemberRepository memberRepository;
    public Book AddBook(Book book) {
        return bookRepository.save(book);
    }

    public void AddBookToMember(Long bookId, Long memberId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()->new RuntimeException("Id not found: "+ bookId));
        Member member = memberRepository.findById(memberId).
                orElseThrow(()->new RuntimeException("Id not found: "+ memberId));
        book.setBorrowedBy(member);
        bookRepository.save(book);
        memberRepository.save(member);

    }

    public void AddBookToLibrary(Long bookId, Long libraryId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()->new RuntimeException("Id not found: "+ bookId));
        Library library = libraryRepository.findById(libraryId)
                .orElseThrow(()-> new RuntimeException("Id not found: "+ libraryId));
        book.setLibrary(library);
        bookRepository.save(book);
        libraryRepository.save(library);

    }
}
