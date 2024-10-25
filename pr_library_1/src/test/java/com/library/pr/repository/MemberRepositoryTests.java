package com.library.pr.repository;

import com.library.pr.domain.Member;
import com.library.pr.domain.MemberRole;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;


@SpringBootTest
@Log4j2
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;


    @Test
    public void insertMembers() {

        IntStream.rangeClosed(1, 3).forEach(i -> {

            Member member = Member.builder()
                    .username("username" + i)
//                    .password(passwordEncoder.encode("1111"))
                    .password("1111")
                    .name("name"+i)
                    .email("email" + i + "@aaa.bbb")
                    .phone("010-2"+i+"23-3333")
                    .build();

            member.addRole(MemberRole.USER);

            if (i >= 90) {
                member.addRole(MemberRole.ADMIN);
            }
            memberRepository.save(member);

        });

    }

    @Test
    public void testRead() {

        Optional<Member> result = memberRepository.getWithRole("user1");

        Member member = result.orElseThrow();

        log.info(member);
        log.info(member.getRoleSet());

        member.getRoleSet().forEach(memberRole -> log.info(memberRole.name()));

    }
}
