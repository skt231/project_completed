package com.library.pr.service;

import com.library.pr.domain.LoanStatus;
import com.library.pr.dto.BookDTO;
import com.library.pr.dto.LoanDTO;
import com.library.pr.dto.PageRequestDTO;
import com.library.pr.dto.PageResponseDTO;

import java.util.List;

public interface LoanService {
    Long register(LoanDTO loanDTO);

    PageResponseDTO<LoanDTO> list(PageRequestDTO pageRequestDTO);

    LoanDTO DetailsLoans(Long loanId);

    List<LoanDTO> getLoansByMember(Long memberId);

    public PageResponseDTO<LoanDTO> searchLoans(PageRequestDTO pageRequestDTO);

    void borrowLoan(Long bookId, Long memberId);

    void returnLoan(Long loanId);

    void modify(LoanDTO loanDTO);

    void remove(Long loanId);

    int countBorrowedLoansByMember(Long memberId);
}
