package com.example.schedule.dto;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Data
public class DtoRequest {
    private Long id;
    private String writer;
    private String todo;
    private Date date;
    private String password;
}
