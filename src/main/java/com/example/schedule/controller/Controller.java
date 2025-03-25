package com.example.schedule.controller;

import com.example.schedule.dto.DtoRequest;
import com.example.schedule.dto.DtoResponse;
import com.example.schedule.dto.DtoUpdateResponse;
import com.example.schedule.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todos")
public class Controller {

    private final TodoService service;

    public Controller(TodoService service) {
        this.service = service;
    }

    // 1. 일정 생성
    @PostMapping("")
    public DtoResponse createTodo(@RequestBody DtoRequest schedule) {
        return service.saveTodo(schedule);
    }

    // 2. 전체 일정 조회
    @GetMapping("")
    public List<DtoResponse> findAllTodo() {
        return service.findAllTodo();
    }

    // 3. 단일 일정 조회
    @GetMapping("/{id}")
    public DtoResponse findTodoById(@PathVariable Long id) {
        return service.findTodoById(id);
    }

    // 4. 일정 수정
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateTodoById(@PathVariable Long id, @RequestBody DtoRequest dto) {
        DtoUpdateResponse updated = service.updateTodoById(id, dto);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "일정이 수정되었습니다.");
        response.put("data", updated);

        return ResponseEntity.ok(response);
    }

    // 5. 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        service.deleteTodoById(id);
        return ResponseEntity.ok("일정 (ID = " + id + ") 삭제 되었습니다.");
    }
}