package com.library.pr.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
abstract class TimestampedEntity {

    @CreatedDate
    @Column(name = "loanDate", updatable = false)
    private LocalDate loanDate;  // 대출일

    private LocalDate dueDate;  // 반납 예정일



    @PrePersist
    public void prePersist() {
        this.dueDate = loanDate.plusWeeks(2);  // loanDate로부터 2주 뒤로 설정

    }
}
