package com.AssignmentLibraryManagement.AssignmentLibraryManagement.Controller;

import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Book;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Member;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository.MemberRepository;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @PostMapping("addMember")
    public ResponseEntity<Member> AddMember(@RequestBody Member member){
        Member member1 = memberService.AddMember(member);
        return new ResponseEntity<>(member1, HttpStatus.CREATED);
    }
    @PostMapping("addLibraryToMember")
    public ResponseEntity<Void> AddLibraryToMember(@RequestParam Long memberId,@RequestParam Long libraryId){
        memberService.AddLibraryToMember(memberId,libraryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("ListOfBook/{memberId}")
    public ResponseEntity<List<Book>> ListOfBook(@PathVariable Long memberId){
        List<Book> books = memberService.ListOfBook(memberId);
        return new ResponseEntity<>(books,HttpStatus.CREATED);
    }

}
