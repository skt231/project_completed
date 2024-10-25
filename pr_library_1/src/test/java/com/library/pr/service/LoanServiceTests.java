package com.library.pr.service;

import com.library.pr.domain.Book;
import com.library.pr.domain.Loan;
import com.library.pr.domain.LoanStatus;
import com.library.pr.domain.Member;
import com.library.pr.dto.BookDTO;
import com.library.pr.dto.LoanDTO;
import com.library.pr.dto.PageRequestDTO;
import com.library.pr.dto.PageResponseDTO;
import com.library.pr.repository.BookRepository;
import com.library.pr.repository.LoanRepository;
import com.library.pr.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Log4j2
public class LoanServiceTests {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanService loanService;

    // 각 테스트 실행 전에 데이터베이스 초기화
    @BeforeEach
    public void clearDatabase() {
        loanRepository.deleteAll();
        bookRepository.deleteAll();
        memberRepository.deleteAll();
    }
    @Test
    public void testRegister() {
        log.info(loanService.getClass().getName());

        // LoanDTO를 생성할 때, username을 사용
        LoanDTO loanDTO = LoanDTO.builder()
                .book_id(3L)  // Book ID
                .member_id(3L)   // Member username
                .status(LoanStatus.BORROWED)  // 대출 상태 (BORROWED)
                .build();

        // 대출 정보를 저장하고 loanId를 반환
        Long loanId = loanService.register(loanDTO);
        log.info("loanId: " + loanId);
    }

    @Test
    public void testGetLoanDetails() {
        // Given: 미리 Book, Member, Loan 엔티티를 저장하여 대출 데이터를 설정
        Book book = Book.builder()
                .bid(1L)
                .btitle("Test Book..")
                .author("Test Author..")
                .publisher("Test Publisher..")
                .isbn("1234567890123")
                .build();

        Book savedBook = bookRepository.save(book);

        Member member = Member.builder()
                .id(1L)
                .username("testuser..")
                .password("password123")
                .name("Test User")
                .email("testuser@example.com")
                .phone("010-1234-5678")
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
    }

    @Test
    public void testListLoans() {
        // Given: Book, Member, Loan 엔티티를 저장하여 대출 데이터를 설정
        Book book1 = Book.builder()
                .btitle("Test Book 1")
                .author("Test Author 1")
                .publisher("Test Publisher 1")
                .isbn("1234567890123")
                .build();

        Book book2 = Book.builder()
                .btitle("Test Book 2")
                .author("Test Author 2")
                .publisher("Test Publisher 2")
                .isbn("9876543210987")
                .build();

        Member member1 = Member.builder()
                .username("user1")
                .password("password1")
                .name("User One")
                .email("user1@example.com")
                .phone("010-1111-1111")
                .build();

        Member member2 = Member.builder()
                .username("user2")
                .password("password2")
                .name("User Two")
                .email("user2@example.com")
                .phone("010-2222-2222")
                .build();

        // Save entities in the repository
        Book savedBook1 = bookRepository.save(book1);
        Book savedBook2 = bookRepository.save(book2);
        Member savedMember1 = memberRepository.save(member1);
        Member savedMember2 = memberRepository.save(member2);

        // Create loans and save them
        Loan loan1 = Loan.builder()
                .book(savedBook1)
                .member(savedMember1)
                .status(LoanStatus.BORROWED)
                .build();

        Loan loan2 = Loan.builder()
                .book(savedBook2)
                .member(savedMember2)
                .status(LoanStatus.BORROWED)
                .build();

        Loan savedLoan1 = loanRepository.save(loan1);
        Loan savedLoan2 = loanRepository.save(loan2);

        // When: LoanService의 list() 메서드로 모든 대출 정보를 조회
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResponseDTO<LoanDTO> pageResponseDTO = loanService.list(pageRequestDTO);

        // Then: 조회한 대출 정보가 예상과 일치하는지 확인
        assertNotNull(pageResponseDTO);
        assertEquals(2, pageResponseDTO.getDtoList().size()); // 두 개의 대출 정보가 있어야 합니다

        LoanDTO loanDTO1 = pageResponseDTO.getDtoList().get(0);
        LoanDTO loanDTO2 = pageResponseDTO.getDtoList().get(1);

        // 첫 번째 대출 정보가 예상과 일치하는지 확인
        assertEquals(savedLoan1.getLoanId(), loanDTO1.getLoanId());
        assertEquals(savedBook1.getBtitle(), loanDTO1.getBookTitle());
        assertEquals(savedMember1.getName(), loanDTO1.getMemberName());
        assertEquals(savedLoan1.getStatus(), loanDTO1.getStatus());

        // 두 번째 대출 정보가 예상과 일치하는지 확인
        assertEquals(savedLoan2.getLoanId(), loanDTO2.getLoanId());
        assertEquals(savedBook2.getBtitle(), loanDTO2.getBookTitle());
        assertEquals(savedMember2.getName(), loanDTO2.getMemberName());
        assertEquals(savedLoan2.getStatus(), loanDTO2.getStatus());

        log.info("LoanDTO List: " + pageResponseDTO.getDtoList());
    }
}


