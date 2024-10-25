package com.library.pr.service;

import com.library.pr.domain.Book;
import com.library.pr.domain.Loan;
import com.library.pr.domain.LoanStatus;
import com.library.pr.dto.*;
import com.library.pr.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService{

    private final ModelMapper modelMapper;

    private final BookRepository bookRepository;

    @Override
    public Long register(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);

        Long bid = bookRepository.save(book).getBid();

        return bid;
    }

    @Override
    public BookDTO readOne(Long bid) {
        Optional<Book> result = bookRepository.findById(bid);

        Book book = result.orElseThrow();

        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);

        return bookDTO;
    }

    @Override
    public void modify(BookDTO bookDTO) {
        Optional<Book> result = bookRepository.findById(bookDTO.getBid());

        Book book = result.orElseThrow();

        book.change(bookDTO.getBtitle(), bookDTO.getAuthor(),bookDTO.getPublisher());

        bookRepository.save(book);
    }

    @Override
    public void remove(Long bid) {
        bookRepository.deleteById(bid);
    }

    @Override
    public PageResponseDTO<BookDTO> list(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("bid");

        Page<Book> result = bookRepository.searchAll(types, keyword, pageable);

        List<BookDTO> dtoList = result.getContent().stream()
                .map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());


        return PageResponseDTO.<BookDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int) result.getTotalElements())
                .build();

    }
}
