package com.library.pr.repository;

import com.library.pr.domain.Book;
import com.library.pr.domain.Loan;
import com.library.pr.dto.BookDTO;
import com.library.pr.repository.search.BookSearch;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> , BookSearch {

    @Query(value = "select now()",nativeQuery = true)
    String getTime();

}

