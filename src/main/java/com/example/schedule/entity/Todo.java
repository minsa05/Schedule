package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;
    private String todo;
    private Date date;

    @PrePersist
    public void prePersist() { // date가 null인경우 현재날짜로
        if (this.date == null) {
            this.date = new Date();
        }
    }

    @Column(nullable = true)
    private String password;


    @CreationTimestamp       //  생성될 때 한 번만 자동 기록
    @Column(updatable = false)  //  수정되지 않도록 설정
    private LocalDateTime createdAt;

    @LastModifiedDate      //  수정될 때마다 자동으로 시간 갱신
    private LocalDateTime updatedAt;
}
