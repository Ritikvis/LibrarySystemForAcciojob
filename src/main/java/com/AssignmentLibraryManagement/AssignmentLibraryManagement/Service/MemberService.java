package com.AssignmentLibraryManagement.AssignmentLibraryManagement.Service;

import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Book;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Library;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Member;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository.LibraryRepository;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private LibraryRepository libraryRepository;
    public Member AddMember(Member member) {
        return memberRepository.save(member);
    }

    public void AddLibraryToMember(Long memberId, Long libraryId) {
        Member member = memberRepository.findById(memberId).
                orElseThrow(()->new RuntimeException("Id not found: "+ memberId));
        Library library = libraryRepository.findById(libraryId)
                .orElseThrow(()-> new RuntimeException("Id not found: "+ libraryId));

        member.setLibrary(library);
        memberRepository.save(member);
        libraryRepository.save(library);

    }

    public List<Book> ListOfBook(Long memberId) {
        Member member = memberRepository.findById(memberId).
                orElseThrow(()->new RuntimeException("Id not found: "+ memberId));
        List<Book> books = member.getBorrowedBooks();
        return books;
    }
}
