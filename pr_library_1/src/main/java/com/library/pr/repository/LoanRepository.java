package com.library.pr.repository;

import com.library.pr.domain.Loan;
import com.library.pr.domain.LoanStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Query(value = "select now()", nativeQuery = true)
    String getTime();

    @Query(value = "SELECT l.loan_id AS loan_id, " +
            "l.book_id AS book_id, " +
            "l.member_id AS member_id, " +
            "TO_CHAR(l.loan_date, 'YYYY-MM-DD') AS loan_date, " +
            "TO_CHAR(l.due_date, 'YYYY-MM-DD') AS due_date, " +
            "b.btitle AS title, " +
            "b.author AS author, " +
            "b.publisher AS publisher, " +
            "b.isbn AS ISBN, " +
            "m.name AS member_name, " +
            "l.status AS status " +
            "FROM Loan l " +
            "JOIN Book b ON l.book_id = b.bid " +
            "JOIN Member m ON l.member_id = m.id " +
            "ORDER BY l.loan_id DESC", // loanId -> loan_id로 수정
            countQuery = "SELECT count(*) FROM Loan l",
            nativeQuery = true)
    Page<Map<String, Object>> listLoan(Pageable pageable);


    @Query(value = "SELECT l.loan_id AS loan_id, " +
            "l.book_id AS book_id, " +
            "l.member_id AS member_id, " +
            "TO_CHAR(l.loan_date, 'YYYY-MM-DD') AS loan_date, " +
            "TO_CHAR(l.due_date, 'YYYY-MM-DD') AS due_date, " +
            "b.btitle AS title, " +
            "b.author AS author, " +
            "b.publisher AS publisher, " +
            "b.isbn AS ISBN, " +
            "m.name AS member_name, " +
            "l.status AS status " +
            "FROM Loan l " +
            "JOIN Book b ON l.book_id = b.bid " +
            "JOIN Member m ON l.member_id = m.id " +
            "WHERE l.loan_id = :loanId", nativeQuery = true)
    Map<String, Object> findLoanDetails(@Param("loanId") Long loanId);

    @Query(value = "SELECT l.loan_id AS loan_id, " +
            "l.book_id AS book_id, " +
            "l.member_id AS member_id, " +
            "TO_CHAR(l.loan_date, 'YYYY-MM-DD') AS loan_date, " +
            "TO_CHAR(l.due_date, 'YYYY-MM-DD') AS due_date, " +
            "b.btitle AS title, " +
            "b.author AS author, " +
            "b.publisher AS publisher, " +
            "b.isbn AS ISBN, " +
            "m.name AS member_name, " +
            "l.status AS status " +
            "FROM Loan l " +
            "JOIN Book b ON l.book_id = b.bid " +
            "JOIN Member m ON l.member_id = m.id " +
            "WHERE l.member_id = :memberId", nativeQuery = true)
    List<Map<String, Object>> findLoansByMemberId(@Param("memberId") Long memberId);

    @Query(value = "SELECT l.loan_id AS loan_id, " +
            "l.book_id AS book_id, " +
            "l.member_id AS member_id, " +
            "TO_CHAR(l.loan_date, 'YYYY-MM-DD') AS loan_date, " +
            "TO_CHAR(l.due_date, 'YYYY-MM-DD') AS due_date, " +
            "b.btitle AS title, " +
            "b.author AS author, " +
            "b.publisher AS publisher, " +
            "b.isbn AS ISBN, " +
            "m.name AS member_name, " +
            "l.status AS status " +
            "FROM Loan l " +
            "JOIN Book b ON l.book_id = b.bid " +
            "JOIN Member m ON l.member_id = m.id " +
            "WHERE LOWER(b.btitle) LIKE LOWER('%' || :keyword || '%')",
            nativeQuery = true)
    Page<Map<String, Object>> searchLoansByBookTitle(@Param("keyword") String keyword, Pageable pageable);

    @Query("SELECT COUNT(l) FROM Loan l WHERE l.member.id = :memberId AND l.status = :status")
    int countByMemberIdAndStatus(@Param("memberId") Long memberId, @Param("status") LoanStatus status);
}



