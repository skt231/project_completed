package com.library.pr.dto;

import com.library.pr.domain.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {

    private Long loanId;      // 대출 ID

    @NotEmpty
    private Long book_id;         // 책 ID (Book 테이블의 참조)

    @NotEmpty
    private String bookTitle;   // 책 제목

//    @NotEmpty
    private String bookAuthor;

//    @NotEmpty
    private String bookISBN;

//    @NotEmpty
    private String bookPublisher;

    @NotEmpty
    private Long member_id;          // 회원 ID (Member 테이블의 참조)

    @NotEmpty
    private String memberName;  // 회원 이름

    //    @NotNull(message = "Year is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate loanDate;  // 대출 날짜

//    @NotNull(message = "Year is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;   // 반납 예정일

//    @NotNull(message = "Year is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate; // 실제 반납일

    private LoanStatus status;     // 대출 상태 ('BORROWED', 'RETURNED', 등)
}
