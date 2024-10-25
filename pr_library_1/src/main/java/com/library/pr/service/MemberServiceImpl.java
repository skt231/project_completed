package com.library.pr.service;

import com.library.pr.domain.Member;
import com.library.pr.domain.MemberRole;
import com.library.pr.dto.MemberJoinDTO;
import com.library.pr.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final ModelMapper modelMapper;

    private final MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void join(MemberJoinDTO memberJoinDTO) throws IdExistException {
        String username = memberJoinDTO.getUsername();

        boolean exist = memberRepository.existsByUsername(username);

        if (exist) {
            throw new IdExistException();
        }

        Member member = modelMapper.map(memberJoinDTO, Member.class);
        member.changePassword(passwordEncoder.encode(memberJoinDTO.getPassword()));
        member.addRole(MemberRole.USER);

        log.info("=======================");
        log.info(member);
        log.info(member.getRoleSet());

        memberRepository.save(member);
    }

    @Override
    public String getLoggedInUsername() {
        return "";
    }

}
