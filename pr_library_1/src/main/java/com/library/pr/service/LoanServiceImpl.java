package com.library.pr.service;

import com.library.pr.domain.Book;
import com.library.pr.domain.Loan;
import com.library.pr.domain.LoanStatus;
import com.library.pr.domain.Member;
import com.library.pr.dto.LoanDTO;
import com.library.pr.dto.PageRequestDTO;
import com.library.pr.dto.PageResponseDTO;
import com.library.pr.repository.BookRepository;
import com.library.pr.repository.LoanRepository;
import com.library.pr.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class LoanServiceImpl implements LoanService {

    private final ModelMapper modelMapper;
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;  // Book 레포지토리 추가
    private final MemberRepository memberRepository;  // Member 레포지토리 추가

    @Override
    public Long register(LoanDTO loanDTO) {
        Book book = bookRepository.findById(loanDTO.getBook_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + loanDTO.getBook_id()));

        Member member = memberRepository.findById(loanDTO.getMember_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID: " + loanDTO.getMember_id()));

        // Loan 엔티티로 변환
        Loan loan = Loan.builder()
                .book(book)  // Book 설정
                .member(member)  // Member 설정
                .status(loanDTO.getStatus())
                .build();

        Long loanId = loanRepository.save(loan).getLoanId();

        return loanId;
    }

    @Override
    public PageResponseDTO<LoanDTO> list(PageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable("loan_id");  // loanId -> loan_id로 수정


        // Loan 리스트를 페이징으로 조회
        Page<Map<String, Object>> resultPage = loanRepository.listLoan(pageable);

        // DTO 변환 작업
        List<LoanDTO> loanDTOList = resultPage.getContent().stream().map(result -> {
            // Null 체크를 통해 안전하게 데이터 변환
            BigDecimal loanIdValue = (BigDecimal) result.get("loan_id");
            BigDecimal bookIdValue = (BigDecimal) result.get("book_id");
            BigDecimal memberIdValue = (BigDecimal) result.get("member_id");

            String bookTitle = (String) result.get("title");
            String memberName = (String) result.get("member_name");
            String author=(String) result.get("author");
            String publisher=(String)result.get("publisher");
            String isbn=(String)result.get("ISBN");

            LocalDate loanDate = result.get("loan_date") != null ? LocalDate.parse((String) result.get("loan_date")) : null;
            LocalDate dueDate = result.get("due_date") != null ? LocalDate.parse((String) result.get("due_date")) : null;

            // LoanStatus 값이 제대로 설정되는지 확인합니다
            String statusValue = (String) result.get("status");  // DB에서 가져온 상태 값
            LoanStatus status = LoanStatus.valueOf(statusValue);  // String을 LoanStatus로 변환

            return LoanDTO.builder()
                    .loanId(loanIdValue != null ? loanIdValue.longValue() : null)
                    .book_id(bookIdValue != null ? bookIdValue.longValue() : null)
                    .bookTitle(bookTitle)
                    .bookAuthor(author)
                    .bookISBN(isbn)
                    .bookPublisher(publisher)
                    .member_id(memberIdValue != null ? memberIdValue.longValue() : null)
                    .memberName(memberName)
                    .loanDate(loanDate)
                    .dueDate(dueDate)
                    .status(status)  // 기본 상태 지정
                    .build();
        }).collect(Collectors.toList());

        // 총 데이터 개수 구함
        int total = (int) resultPage.getTotalElements();

        // PageResponseDTO 반환
        return PageResponseDTO.<LoanDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(loanDTOList)
                .total(total)
                .build();
    }
    @Override
    public LoanDTO DetailsLoans(Long loanId) {
        Map<String, Object> result = loanRepository.findLoanDetails(loanId);

        // Null 체크를 통해 안전하게 데이터 변환
        BigDecimal loanIdValue = (BigDecimal) result.get("loan_id");
        BigDecimal bookIdValue = (BigDecimal) result.get("book_id");
        BigDecimal memberIdValue = (BigDecimal) result.get("member_id");

        String bookTitle = (String) result.get("title");
        String memberName = (String) result.get("member_name");
        String author = (String) result.get("author");
        String publisher = (String) result.get("publisher");
        String isbn = (String) result.get("ISBN");

        LocalDate loanDate = result.get("loan_date") != null ? LocalDate.parse((String) result.get("loan_date")) : null;
        LocalDate dueDate = result.get("due_date") != null ? LocalDate.parse((String) result.get("due_date")) : null;

        // LoanStatus 값이 제대로 설정되는지 확인합니다
        String statusValue = (String) result.get("status");  // DB에서 가져온 상태 값
        LoanStatus status = LoanStatus.valueOf(statusValue);  // String을 LoanStatus로 변환

        // Map에서 값을 추출해 DTO로 변환
        return LoanDTO.builder()
                .loanId(loanIdValue != null ? loanIdValue.longValue() : null)
                .book_id(bookIdValue != null ? bookIdValue.longValue() : null)
                .bookTitle(bookTitle)
                .bookAuthor(author)
                .bookISBN(isbn)
                .bookPublisher(publisher)
                .member_id(memberIdValue != null ? memberIdValue.longValue() : null)
                .memberName(memberName)
                .loanDate(loanDate)
                .dueDate(dueDate)
                .status(status)  // 기본 상태 지정
                .build();
    }

    @Override
    public List<LoanDTO> getLoansByMember(Long memberId) {
        List<Map<String, Object>> resultList = loanRepository.findLoansByMemberId(memberId);

        return resultList.stream().map(result -> {
            BigDecimal loanIdValue = (BigDecimal) result.get("loan_id");
            BigDecimal bookIdValue = (BigDecimal) result.get("book_id");
            BigDecimal memberIdValue = (BigDecimal) result.get("member_id");

            String bookTitle = (String) result.get("title");
            String memberName = (String) result.get("member_name");
            String author = (String) result.get("author");
            String publisher = (String) result.get("publisher");
            String isbn = (String) result.get("ISBN");

            LocalDate loanDate = result.get("loan_date") != null ? LocalDate.parse((String) result.get("loan_date")) : null;
            LocalDate dueDate = result.get("due_date") != null ? LocalDate.parse((String) result.get("due_date")) : null;

            // LoanStatus 값이 제대로 설정되는지 확인합니다
            String statusValue = (String) result.get("status");  // DB에서 가져온 상태 값
            LoanStatus status = LoanStatus.valueOf(statusValue);  // String을 LoanStatus로 변환

            return LoanDTO.builder()
                    .loanId(loanIdValue != null ? loanIdValue.longValue() : null)
                    .book_id(bookIdValue != null ? bookIdValue.longValue() : null)
                    .bookTitle(bookTitle)
                    .bookAuthor(author)
                    .bookISBN(isbn)
                    .bookPublisher(publisher)
                    .member_id(memberIdValue != null ? memberIdValue.longValue() : null)
                    .memberName(memberName)
                    .loanDate(loanDate)
                    .dueDate(dueDate)
                    .status(status)  // 기본 상태 지정
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public PageResponseDTO<LoanDTO> searchLoans(PageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable("loan_id");
        String keyword = pageRequestDTO.getKeyword();
        Page<Map<String, Object>> resultPage = loanRepository.searchLoansByBookTitle(keyword, pageable);

        // 변환 작업 수행
        List<LoanDTO> loanDTOList = resultPage.getContent().stream().map(result -> {
            BigDecimal loanIdValue = (BigDecimal) result.get("loan_id");
            BigDecimal bookIdValue = (BigDecimal) result.get("book_id");
            BigDecimal memberIdValue = (BigDecimal) result.get("member_id");

            String bookTitle = (String) result.get("title");
            String memberName = (String) result.get("member_name");
            String author = (String) result.get("author");
            String publisher = (String) result.get("publisher");
            String isbn = (String) result.get("ISBN");

            LocalDate loanDate = result.get("loan_date") != null ? LocalDate.parse((String) result.get("loan_date")) : null;
            LocalDate dueDate = result.get("due_date") != null ? LocalDate.parse((String) result.get("due_date")) : null;

            // LoanStatus 값이 제대로 설정되는지 확인합니다
            String statusValue = (String) result.get("status");  // DB에서 가져온 상태 값
            LoanStatus status = LoanStatus.valueOf(statusValue);  // String을 LoanStatus로 변환

            return LoanDTO.builder()
                    .loanId(loanIdValue != null ? loanIdValue.longValue() : null)
                    .book_id(bookIdValue != null ? bookIdValue.longValue() : null)
                    .bookTitle(bookTitle)
                    .bookAuthor(author)
                    .bookISBN(isbn)
                    .bookPublisher(publisher)
                    .member_id(memberIdValue != null ? memberIdValue.longValue() : null)
                    .memberName(memberName)
                    .loanDate(loanDate)
                    .dueDate(dueDate)
                    .status(status)  // 기본 상태 지정
                    .build();
        }).collect(Collectors.toList());

        int total = (int) resultPage.getTotalElements();

        return PageResponseDTO.<LoanDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(loanDTOList)
                .total((int) resultPage.getTotalElements())
                .build();
    }

    @Override
    public void borrowLoan(Long bookId, Long memberId) {

        // 대출할 책 정보를 가져옴
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));

        // 대출할 회원 정보를 가져옴
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        // Loan 엔티티 생성 및 정보 설정
        Loan loan = Loan.builder()
                .book(book)
                .member(member)
                .status(LoanStatus.BORROWED)
                .build();

        // Loan 정보 저장
        loanRepository.save(loan);
    }

//    @Override
//    public LoanStatus getLoanStatusByBookId(Long bookId) {
//        Optional<Loan> loanOptional = loanRepository.findTopByBookBidOrderByLoanDateDesc(bookId);
//        return loanOptional.map(Loan::getStatus).orElse(null);
//    }
//    @Override
//public LoanStatus getLoanStatusByBookId(Long bookId) {
//    List<Loan> loans = loanRepository.findByBook_BidOrderByLoanDateDesc(bookId);
//        if (loans.isEmpty()) {
//            return null;
//        }
//        Loan latestLoan = loans.get(0);
//        LoanStatus status = latestLoan.getStatus();
//        log.info("Book ID: {}, Loan Status: {}", bookId, status);
//    return latestLoan.getStatus();
//}
    @Override
    public int countBorrowedLoansByMember(Long memberId) {
        return loanRepository.countByMemberIdAndStatus(memberId, LoanStatus.BORROWED);
    }

    @Override
    public void returnLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid loan ID: " + loanId));

        loan.setReturnDate(LocalDate.now()); // 반납 날짜를 오늘로 설정
        // Loan의 상태를 RETURNED로 변경
        loan.setStatus(LoanStatus.RETURNED);

        // 변경된 상태를 저장
        loanRepository.save(loan);
    }



    @Override
    public void modify(LoanDTO loanDTO) {

    }

    @Override
    public void remove(Long loanId) {

    }
}
