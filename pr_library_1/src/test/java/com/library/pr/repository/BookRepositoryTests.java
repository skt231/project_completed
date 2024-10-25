package com.library.pr.repository;

import com.library.pr.domain.Book;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void TestInsert(){
        IntStream.rangeClosed(1,3).forEach(i->{
           Book book= Book.builder()
                   .btitle("z"+i)
                   .author("zx"+i)
                   .publisher("z"+i)
                   .isbn("z"+i)
                   .build();
            Book result = bookRepository.save(book);
            log.info("bid: "+result+result.getBid());
        });
    }
    @Test
    public void testSelect(){
        Long bid=100L;
        Optional<Book> result = bookRepository.findById(bid);
        Book book=result.orElseThrow();
        log.info(book);
    }

    @Test
    public void testUpdate(){
        Long bid=100L;
        Optional<Book> result=bookRepository.findById(bid);
        Book book=result.orElseThrow();
        book.change("update...title100", "update...author100", "update...publisher100");
        bookRepository.save(book);
    }

    @Test
    public void testDelete(){
        Long bid=33L;
        bookRepository.deleteById(bid);
    }

    @Test
    public void testPaging(){
        Pageable pageable= PageRequest.of(0,10, Sort.by("bid").descending());
        Page<Book> result=bookRepository.findAll(pageable);

        log.info("total count: "+result.getTotalElements());
        log.info("total pages: "+result.getTotalPages());
        log.info("page number: "+result.getNumber());
        log.info("page size: "+result.getSize());

        List<Book> todoList=result.getContent();

        todoList.forEach(book -> log.info(book));
    }

    @Test
    public void testSeatch1(){
        //2page order by bno desc
        Pageable pageable=PageRequest.of(1,10,Sort.by("bid").descending());
        bookRepository.search1(pageable);
    }

    @Test
    public void testSearchAll() {

        String[] types = {"t", "c", "w","s"};

        String keyword = "1";

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bid").descending());

        Page<Book> result = bookRepository.searchAll(types, keyword, pageable);

    }

    @Test
    public void testSearchAll2() {

        String[] types = {"t", "c", "w","s"};

        String keyword = "1";

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bid").descending());

        Page<Book> result = bookRepository.searchAll(types, keyword, pageable);

        //total pages
        log.info(result.getTotalPages());

        //pag size
        log.info(result.getSize());

        //pageNumber
        log.info(result.getNumber());

        //prev next
        log.info(result.hasPrevious() + ": " + result.hasNext());

        result.getContent().forEach(book -> log.info(book));
    }
}
