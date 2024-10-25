package com.library.pr.service;

import com.library.pr.dto.MemberJoinDTO;

public interface MemberService {
    static class IdExistException extends Exception {

    }

    void join(MemberJoinDTO memberJoinDTO) throws IdExistException;

    public String getLoggedInUsername();
}
