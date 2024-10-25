package com.library.pr.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class MemberSecurityDTO extends User {
    private Long memberId; // member_id 추가

    private String username;

    private String password;

    private String name;

    private String email;

    private String phone;

    public MemberSecurityDTO(Long id,String username, String password,String name,String email,String phone,
                             Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.memberId=id;
        this.username=username;
        this.password=password;
        this.name=name;
        this.email=email;
        this.phone=phone;
    }

}
