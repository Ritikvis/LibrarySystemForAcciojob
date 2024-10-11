package com.AssignmentLibraryManagement.AssignmentLibraryManagement.Service;

import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Librarian;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Library;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Member;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository.LibrarianRepository;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository.LibraryRepository;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {
    @Autowired
    private LibrarianRepository librarianRepository;
    @Autowired
    private MemberRepository memberRepository;
    public Librarian AddLibrarian(Librarian librarian) {
        return librarianRepository.save(librarian);

    }

    public void AddMemberToLibrarian(Long librarianId, Long memberId) {
        Librarian librarian = librarianRepository.findById(librarianId)
                .orElseThrow(()-> new RuntimeException("Id not found : " +  librarianId));
        Member member = memberRepository.findById(memberId).
                orElseThrow(()->new RuntimeException("Id not found: "+ memberId));
        librarian.getMembers().add(member);
        member.getLibrarians().add(librarian);
        librarianRepository.save(librarian);
        memberRepository.save(member);
    }

    public List<Library> ListOfLibraries(Long librarianId) {
        Librarian librarian = librarianRepository.findById(librarianId)
                .orElseThrow(()-> new RuntimeException("Id not found : " +  librarianId));
        List<Library> libraries = librarian.getLibraries();
        return libraries;

    }
}
