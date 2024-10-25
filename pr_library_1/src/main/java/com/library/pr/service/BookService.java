package com.library.pr.service;

import com.library.pr.dto.*;

import java.util.List;

public interface BookService {

    Long register(BookDTO bookDTO);

    BookDTO readOne(Long bid);

    void modify(BookDTO bookDTO);

    void remove(Long bid);

    PageResponseDTO<BookDTO> list(PageRequestDTO pageRequestDTO);

}
