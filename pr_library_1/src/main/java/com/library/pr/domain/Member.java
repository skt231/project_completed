package com.library.pr.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "roleSet")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 자동으로 생성되는 숫자 ID

    private String username;  // 로그인에 사용할 유저명

    private String password;

    private String name;

    private String email;

    private String phone;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "member_role_set", joinColumns = @JoinColumn(name = "member_id"))
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    public void changePassword(String password) {
        this.password = password;
    }

    public void addRole(MemberRole memberRole) {
        this.roleSet.add(memberRole);
        if (memberRole == MemberRole.ADMIN) {
            this.roleSet.add(memberRole.ADMIN);
        }
    }

    public void clearRoles() {
        this.roleSet.clear();
    }
}


