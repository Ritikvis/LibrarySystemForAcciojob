package com.AssignmentLibraryManagement.AssignmentLibraryManagement.Controller;

import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Librarian;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Library;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Service.LibrarianService;
import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Librarian")
public class LibrarianController {
    @Autowired
    private LibrarianService librarianService;
    @PostMapping("AddLibrarian")
    public ResponseEntity<Librarian> AddLibrarian(@RequestBody Librarian librarian){
        Librarian librarian1 = librarianService.AddLibrarian(librarian);
        return new ResponseEntity<>(librarian1,HttpStatus.CREATED);
    }
    @PostMapping("addMemberToLibrarian")
    public ResponseEntity<Void> AddMemberToLibrarian(@RequestParam Long librarianId , @RequestParam Long memberId){
        librarianService.AddMemberToLibrarian(librarianId,memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("ListOfLibraries/{librarianId}")
    public ResponseEntity<List<Library>> ListOfLibraries(@PathVariable Long librarianId){
        List<Library> libraries = librarianService.ListOfLibraries(librarianId);
        return new ResponseEntity<>(libraries,HttpStatus.CREATED);
    }


}
