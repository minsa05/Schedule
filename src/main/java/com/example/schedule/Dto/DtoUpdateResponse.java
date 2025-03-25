package com.example.schedule.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoUpdateResponse {
    private Long id;
    private String writer;
    private String todo;
    private Date date;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;  // 수정 후 응답에만 나타남
}
