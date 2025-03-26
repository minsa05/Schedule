package com.example.schedule.service;

import com.example.schedule.dto.DtoRequest;
import com.example.schedule.dto.DtoResponse;
import com.example.schedule.dto.DtoUpdateResponse;
import com.example.schedule.entity.Todo;
import com.example.schedule.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    // 생성자 주입
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // 일정 생성
    @Transactional
    public DtoResponse saveTodo(DtoRequest dtoRequest) {
        Todo todo = new Todo();
        todo.setWriter(dtoRequest.getWriter());
        todo.setPassword(dtoRequest.getPassword()); // 저장은 하지만 보이지않게
        todo.setTodo(dtoRequest.getTodo());
        todo.setDate(dtoRequest.getDate());

        Todo savedTodo = todoRepository.save(todo);

        return new DtoResponse( // 출력
                savedTodo.getId(),
                savedTodo.getWriter(),
                savedTodo.getTodo(),
                savedTodo.getDate(),
                savedTodo.getCreatedAt()
        );
    }


    // 전체 일정 조회
    @Transactional(readOnly = true)
    public List<DtoResponse> findAllTodo() {
        return todoRepository.findAll().stream()
                .map(todo -> new DtoResponse( // 출력
                        todo.getId(),
                        todo.getWriter(),
                        todo.getTodo(),
                        todo.getDate(),
                        todo.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }

    // 단일 일정 조회
    @Transactional(readOnly = true)
    public DtoResponse findTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("일정이 존재하지 않습니다."));

        return new DtoResponse( // 출력
                todo.getId(),
                todo.getWriter(),
                todo.getTodo(),
                todo.getDate(),
                todo.getCreatedAt()
        );
    }

    // 일정 수정
    @Transactional
    public DtoUpdateResponse updateTodoById(Long id, DtoRequest dtoRequest) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("일정이 존재하지 않습니다."));

        todo.setWriter(dtoRequest.getWriter());
        todo.setTodo(dtoRequest.getTodo());
        todo.setDate(dtoRequest.getDate());

        Todo updatedTodo = todoRepository.save(todo);

        return new DtoUpdateResponse( // 출력
                updatedTodo.getId(),
                updatedTodo.getWriter(),
                updatedTodo.getTodo(),
                updatedTodo.getDate(),
                updatedTodo.getCreatedAt(),
                updatedTodo.getUpdatedAt()
        );
    }


    // 일정 삭제
    @Transactional
    public void deleteTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("일정이 존재하지 않습니다."));
        todoRepository.delete(todo);
    }
}