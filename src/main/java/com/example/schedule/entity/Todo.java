package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.time.LocalDateTime;

@Entity
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;
    private String todo;
    private Date date;

    @Column(nullable = true)
    private String password;


    @CreationTimestamp       //  생성될 때 한 번만 자동 기록
    @Column(updatable = false)  //  수정되지 않도록 설정
    private LocalDateTime createdAt;

    @UpdateTimestamp         //  수정될 때마다 자동으로 시간 갱신
    private LocalDateTime updatedAt;
}
