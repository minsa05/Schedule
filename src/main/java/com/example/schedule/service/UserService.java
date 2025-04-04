package com.example.schedule.service;

import com.example.schedule.dto.DtoUserRequest;
import com.example.schedule.dto.DtoUserResponse;
import com.example.schedule.entity.UserEntity;
import com.example.schedule.exception.NotFoundException;
import com.example.schedule.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    // 생성자 주입
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 유저 생성 (회원가입)
    @Transactional
    public DtoUserResponse createUser(DtoUserRequest dtoUserRequest) {
        UserEntity user = new UserEntity();
        user.setUsername(dtoUserRequest.getUsername());
        user.setPassword(dtoUserRequest.getPassword()); // 실제 서비스에서는 해시 처리 필요

        UserEntity savedUser = userRepository.save(user);
        return new DtoUserResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getCreatedAt(),
                savedUser.getUpdatedAt()
        );
    }

    // 전체 유저 조회
    @Transactional(readOnly = true)
    public List<DtoUserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new DtoUserResponse(
                        user.getId(),
                        user.getUsername(),
                        user.getCreatedAt(),
                        user.getUpdatedAt()
                ))
                .collect(Collectors.toList());
    }

    // 단일 유저 조회
    @Transactional(readOnly = true)
    public DtoUserResponse getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("유저가 존재하지 않습니다."));
        return new DtoUserResponse(
                user.getId(),
                user.getUsername(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    // 유저 정보 수정
    @Transactional
    public DtoUserResponse updateUser(Long id, DtoUserRequest dtoUserRequest) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("유저가 존재하지 않습니다."));
        user.setUsername(dtoUserRequest.getUsername());
        user.setPassword(dtoUserRequest.getPassword()); // 필요한 경우 비밀번호 수정도 포함

        UserEntity updatedUser = userRepository.save(user);
        return new DtoUserResponse(
                updatedUser.getId(),
                updatedUser.getUsername(),
                updatedUser.getCreatedAt(),
                updatedUser.getUpdatedAt()
        );
    }

    // 유저 삭제
    @Transactional
    public void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("유저가 존재하지 않습니다."));
        userRepository.delete(user);
    }
}
