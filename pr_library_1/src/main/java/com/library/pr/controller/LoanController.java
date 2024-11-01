package com.library.pr.controller;

import com.library.pr.dto.BookDTO;
import com.library.pr.dto.LoanDTO;
import com.library.pr.dto.PageRequestDTO;
import com.library.pr.dto.PageResponseDTO;
import com.library.pr.security.dto.MemberSecurityDTO;
import com.library.pr.service.BookService;
import com.library.pr.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/loan")
@Log4j2
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public String listLoans(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO<LoanDTO> responseDTO;


        if (pageRequestDTO.getKeyword() != null && !pageRequestDTO.getKeyword().isEmpty()) {
            responseDTO = loanService.searchLoans(pageRequestDTO);
        } else {
            responseDTO = loanService.list(pageRequestDTO);
        }

        model.addAttribute("loans", responseDTO.getDtoList());
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        model.addAttribute("responseDTO", responseDTO);
        return "loan/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/register")
    public void registerGET() {

    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/register")
    public String registerPost(@Valid LoanDTO loanDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        log.info("board POST register.......");

        if (bindingResult.hasErrors()) {
            log.info("has errors.......");
            bindingResult.getAllErrors().forEach(error -> log.info(error.toString())); // 오류 메시지 로그 추가
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/loan/register";
        }

        log.info(loanDTO);

        Long bid = loanService.register(loanDTO);

        redirectAttributes.addFlashAttribute("result", bid);

        return "redirect:/loan/list";
    }

    // LoanId를 클릭했을 때 상세 대출 정보를
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/details/{loanId}")
    public String detailsLoan(@PathVariable Long loanId, Model model) {
        LoanDTO loanDTO = loanService.DetailsLoans(loanId);

        model.addAttribute("loan", loanDTO);

        return "loan/details";
    }
//id별 대출
@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/member/memberLoans/{memberId}")
public String memberLoans(@PathVariable Long memberId, Model model) {
    List<LoanDTO> memberLoans = loanService.getLoansByMember(memberId);
    model.addAttribute("loans", memberLoans);
    return "loan/memberLoans";
}

    // 대출 목록 조회 페이지
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/myLoans/LoansStatus")
    public String getMyLoans(@AuthenticationPrincipal MemberSecurityDTO memberSecurityDTO, Model model) {
        Long memberId = memberSecurityDTO.getMemberId();
        List<LoanDTO> memberLoans = loanService.getLoansByMember(memberId);
        model.addAttribute("loans", memberLoans);
        return "member/LoansStatus";
    }

    // 대출 반납을 처리하는 메소드
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/return/{loanId}")
    public String returnLoan(@PathVariable Long loanId, @AuthenticationPrincipal MemberSecurityDTO memberSecurityDTO, RedirectAttributes redirectAttributes) {
        log.info("Returning loan with ID: " + loanId);
        Long memberId = memberSecurityDTO.getMemberId();
        try {
            loanService.returnLoan(loanId);
            redirectAttributes.addFlashAttribute("result", "success");
            log.info("Loan returned successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "반납에 실패했습니다.");
            log.info("Failed to return the loan.");
        }

        return "redirect:/loan/myLoans/LoansStatus";
    }

    // 대출 처리
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/borrow/{bookId}")
    public String borrowBook(@PathVariable Long bookId, @AuthenticationPrincipal MemberSecurityDTO memberSecurityDTO, RedirectAttributes redirectAttributes) {
        Long memberId = memberSecurityDTO.getMemberId();
        try {
            // 현재 회원의 대출 중인 책 개수
            int borrowedCount = loanService.countBorrowedLoansByMember(memberId);
            if (borrowedCount >= 3) {
                redirectAttributes.addFlashAttribute("error", "대출 가능한 권수를 초과하였습니다. (최대 3권)");
                return "redirect:/book/list";
            }
            loanService.borrowLoan(bookId, memberId);
            redirectAttributes.addFlashAttribute("result", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "대출에 실패했습니다.");
        }

        return "redirect:/book/list";
    }
}
