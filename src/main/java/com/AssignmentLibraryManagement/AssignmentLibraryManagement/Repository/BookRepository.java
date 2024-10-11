package com.AssignmentLibraryManagement.AssignmentLibraryManagement.Repository;

import com.AssignmentLibraryManagement.AssignmentLibraryManagement.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
