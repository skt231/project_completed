package com.library.pr.security;

import com.library.pr.domain.Member;
import com.library.pr.repository.MemberRepository;
import com.library.pr.security.dto.MemberSecurityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername: " + username);

        Optional<Member> result = memberRepository.getWithRole(username);

        if (result.isEmpty()) { //해당 아이디를 가진 사용자가 없다면
            throw new UsernameNotFoundException("username not found...");
        }

        Member member = result.get();
        log.info("Roles: " + member.getRoleSet());
        MemberSecurityDTO memberSecurityDTO =
                new MemberSecurityDTO(
                        member.getId(),
                        member.getUsername(),
                        member.getPassword(),
                        member.getName(),
                        member.getEmail(),
                        member.getPhone(),
                        member.getRoleSet()
                                .stream()
                                .map(memberRole -> new SimpleGrantedAuthority("ROLE_" + memberRole))
                                .collect(Collectors.toList())
                );
        log.info("role"+ memberSecurityDTO.getAuthorities());
        log.info("User Roles: " + member.getRoleSet());
        log.info("memberSecurityDTO");
        log.info(memberSecurityDTO);

        return memberSecurityDTO;
    }
}
