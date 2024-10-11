package com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long librarianId;
    private String librarianName;

    @ManyToMany
    @JoinTable(
            name = "librarian_member",
            joinColumns = @JoinColumn(name = "librarian_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<Member> members;

    @ManyToMany(mappedBy = "librarians")
    private List<Library> libraries;
    public Librarian(){}

    public Librarian(Long librarianId, String librarianName, List<Member> members, List<Library> libraries) {
        this.librarianId = librarianId;
        this.librarianName = librarianName;
        this.members = members;
        this.libraries = libraries;
    }

    public Long getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(Long librarianId) {
        this.librarianId = librarianId;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }
}
