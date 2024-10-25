package com.library.pr.repository;

import com.library.pr.domain.Book;
import com.library.pr.domain.Loan;
import com.library.pr.domain.LoanStatus;
import com.library.pr.domain.Member;
import com.library.pr.dto.LoanDTO;
import com.library.pr.service.LoanService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDate;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class LoanRepositoryTests {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanService loanService;

//        @BeforeEach
//    public void clearDatabase() {
//        loanRepository.deleteAll();
//        bookRepository.deleteAll();
//        memberRepository.deleteAll();
//    }
    @Test
    @Transactional
    public void TestInsertLoan() {
        // 미리 생성된 Book 및 Member 데이터를 참조하여 Loan 데이터를 삽입
        IntStream.rangeClosed(1, 3).forEach(i -> {
            // Book 데이터를 먼저 생성 또는 참조
            Book book = Book.builder()
                    .btitle("test" + i)
                    .author("ast" + i)
                    .publisher("pst" + i)
                    .isbn("ist" + i)
                    .build();
            Book savedBook = bookRepository.save(book);

            // Member 데이터를 생성 또는 참조
            Member member = Member.builder()
                    .username("user" + i)
                    .password("password" + i)
                    .email("user" + i + "@library.com")
                    .name("User Name " + i)  // name 필드 추가
                    .build();
            Member savedMember = memberRepository.save(member);

            // Loan 데이터 생성
            Loan loan = Loan.builder()
                    .book(savedBook)  // 위에서 저장된 Book 객체
                    .member(savedMember)  // 위에서 저장된 Member 객체
                    .status(LoanStatus.BORROWED)  // 기본 상태를 BORROWED로 설정
                    .build();

            Loan savedLoan = loanRepository.save(loan);
            log.info("loanId: " + savedLoan.getLoanId());
        });
    }

    @Test
    public void testgetAllLoans() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            // Book 데이터를 먼저 생성 또는 참조
            Book book = Book.builder()
                    .btitle("title...." + i)
                    .author("author...." + i)
                    .publisher("publisher..." + i)
                    .isbn("isbn...." + i)
                    .build();
            Book savedBook = bookRepository.save(book);

            // Member 데이터를 생성 또는 참조
            Member member = Member.builder()
                    .username("user..." + i)
                    .password("password" + i)
                    .email("user" + i + "@library.com")
                    .name("User Name " + i)  // name 필드 추가
                    .build();
            Member savedMember = memberRepository.save(member);

            Loan loan = Loan.builder()
                    .book(savedBook)
                    .member(savedMember)
                    .status(LoanStatus.BORROWED)
                    .build();

            Loan savedLoan = loanRepository.save(loan);

            // When: LoanService의 getLoanDetails 메서드로 대출 정보를 조회
            LoanDTO loanDTO = loanService.DetailsLoans(savedLoan.getLoanId());

            // Then: 조회한 대출 정보가 예상과 일치하는지 확인
            assertNotNull(loanDTO);
            assertEquals(savedLoan.getLoanId(), loanDTO.getLoanId());
            assertEquals(savedBook.getBtitle(), loanDTO.getBookTitle());
            assertEquals(savedMember.getName(), loanDTO.getMemberName());
            assertEquals(savedLoan.getStatus(), loanDTO.getStatus());

            log.info("LoanDTO: " + loanDTO);
        });
    }
}
