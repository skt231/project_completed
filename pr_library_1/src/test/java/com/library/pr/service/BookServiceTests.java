package com.library.pr.service;

import com.library.pr.dto.BookDTO;
import com.library.pr.dto.PageRequestDTO;
import com.library.pr.dto.PageResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BookServiceTests {

    @Autowired
    private BookService bookService;

    @Test
    public void testRegister(){

        log.info(bookService.getClass().getName());

        BookDTO bookDTO = BookDTO.builder()
                .btitle("z")
                .author("z")
                .publisher("zr")
                .isbn("Szn")
                .build();

        Long bid = bookService.register(bookDTO);
        log.info("bid: " + bid);
    }

    @Test
    public void testModify() {

        BookDTO bookDTO = BookDTO.builder()
                .bid(32L)
                .btitle("Updated....33")
                .author("Updated author 101...")
                .publisher("Updated...33")
                .build();

        bookService.modify(bookDTO);

    }

    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcws")
                .keyword("1")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<BookDTO> responseDTO = bookService.list(pageRequestDTO);

        log.info(responseDTO);

    }
}
