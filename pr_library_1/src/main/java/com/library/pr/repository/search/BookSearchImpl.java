package com.library.pr.repository.search;

import com.library.pr.domain.Book;
import com.library.pr.domain.QBook;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;


public class BookSearchImpl extends QuerydslRepositorySupport implements BookSearch {

    public BookSearchImpl(){
        super(Book.class);
    }

    @Override
    public Page<Book> search1(Pageable pageable) {
        QBook book= QBook.book;//Q도메인

        JPQLQuery<Book> query=from(book);//select... from book
        BooleanBuilder booleanBuilder=new BooleanBuilder(); //(
        booleanBuilder.or(book.btitle.contains("11"));//title like...
        booleanBuilder.or(book.author.contains("11"));//author like...

        query.where(booleanBuilder);
        query.where(book.bid.gt(0L));

        // paging
        this.getQuerydsl().applyPagination(pageable,query);

        List<Book> list=query.fetch();
        long count=query.fetchCount();
        return null;
    }

    @Override
    public Page<Book> searchAll(String[] types, String keyword, Pageable pageable) {
        QBook book = QBook.book;
        JPQLQuery<Book> query = from(book);

        if ((types != null && types.length > 0) && keyword != null) { //검색 조건과 키워드가 있다면

            BooleanBuilder booleanBuilder = new BooleanBuilder(); // (

            for (String type : types) {

                switch (type) {
                    case "t":
                        booleanBuilder.or(book.btitle.contains(keyword));
                        break;
                    case "a":
                        booleanBuilder.or(book.author.contains(keyword));
                        break;
                    case "i":
                        booleanBuilder.or(book.isbn.contains(keyword));
                        break;
                    case "p":
                        booleanBuilder.or(book.publisher.contains(keyword));
                        break;
                }
            }//end for
            query.where(booleanBuilder);
        }//end if

        //bid > 0
        query.where(book.bid.gt(0L));

        //paging
        this.getQuerydsl().applyPagination(pageable, query);

        List<Book> list = query.fetch();

        long count = query.fetchCount();

        return new PageImpl<>(list, pageable, count);

    }
}
