package com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository;

import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  LibrarianRepository extends JpaRepository<Librarian,Long> {
}
