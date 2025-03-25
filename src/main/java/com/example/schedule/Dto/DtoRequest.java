package com.example.schedule.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoRequest {
    private Long id;
    private String writer;
    private String todo;
    private Date date;
    private String password;
}
