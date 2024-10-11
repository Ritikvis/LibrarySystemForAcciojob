package com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long libraryId;

    private String location;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List<Member> members;

    @ManyToMany
    @JoinTable(
            name = "library_librarian",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "librarian_id")
    )
    private List<Librarian> librarians;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List<Book> availableBooks;
    public Library(){}

    public Library(Long libraryId, String location, List<Member> members, List<Librarian> librarians, List<Book> availableBooks) {
        this.libraryId = libraryId;
        this.location = location;
        this.members = members;
        this.librarians = librarians;
        this.availableBooks = availableBooks;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(List<Librarian> librarians) {
        this.librarians = librarians;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }
}
