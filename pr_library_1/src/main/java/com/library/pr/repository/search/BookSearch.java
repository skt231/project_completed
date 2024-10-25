package com.library.pr.repository.search;

import com.library.pr.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookSearch {
    Page<Book> search1(Pageable pageable);

    Page<Book> searchAll(String[] types,String keyword,Pageable pageable);
}
