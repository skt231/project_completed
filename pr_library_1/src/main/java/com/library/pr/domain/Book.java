package com.library.pr.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid;

    @Column(length =255 , nullable = false)
    private String btitle;

    @Column(length = 255 , nullable = false)
    private String author;

    @Column(length =255 , nullable = false)
    private String publisher;

    @Column(length =13 , nullable = false)
    private String isbn;

    @Column(name = "byear")
    private LocalDate byear;

    public void change(String btitle,String author,String publisher){
        this.btitle=btitle;
        this.author=author;
        this.publisher=author;
    }
}
