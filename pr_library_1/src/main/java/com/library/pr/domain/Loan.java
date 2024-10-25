package com.library.pr.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Loan extends TimestampedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;  // 자동 생성되는 ID

    @ManyToOne(fetch = FetchType.LAZY)  // Lazy loading 설정
    @JoinColumn(name = "member_id", nullable = false)  // member_id는 null이 될 수 없음
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)  // bid도 null이 될 수 없음
    private Book book;

    private LocalDate returnDate;  // 실제 반납일 (반납되지 않은 경우 null)

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private LoanStatus status;  // 대출 상태 (BORROWED, RETURNED, LATE)

    // 상태 변경 메서드
    public void changeStatus(LoanStatus status) {
        this.status = status;
    }
}
