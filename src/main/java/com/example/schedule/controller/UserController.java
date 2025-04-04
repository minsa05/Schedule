package com.example.schedule.controller;

import com.example.schedule.dto.DtoUserRequest;
import com.example.schedule.dto.DtoUserResponse;
import com.example.schedule.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // 생성자 주입
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 유저 생성 (회원가입)
    @PostMapping
    public ResponseEntity<DtoUserResponse> createUser(@RequestBody DtoUserRequest dtoUserRequest) {
        DtoUserResponse userResponse = userService.createUser(dtoUserRequest);
        return ResponseEntity.ok(userResponse);
    }

    // 전체 유저 조회
    @GetMapping
    public ResponseEntity<List<DtoUserResponse>> getAllUsers() {
        List<DtoUserResponse> userResponses = userService.getAllUsers();
        return ResponseEntity.ok(userResponses);
    }

    // 단일 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<DtoUserResponse> getUserById(@PathVariable Long id) {
        DtoUserResponse userResponse = userService.getUserById(id);
        return ResponseEntity.ok(userResponse);
    }

    // 유저 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable Long id,
                                                          @RequestBody DtoUserRequest dtoUserRequest) {
        DtoUserResponse userResponse = userService.updateUser(id, dtoUserRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("id", userResponse.getId());
        response.put("username", userResponse.getUsername());
        response.put("createdAt", userResponse.getCreatedAt());
        response.put("updatedAt", userResponse.getUpdatedAt());
        response.put("message", "일정이 수정되었습니다.");

        return ResponseEntity.ok(response);
    }



    // 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("유저가 삭제되었습니다.");
    }
}
