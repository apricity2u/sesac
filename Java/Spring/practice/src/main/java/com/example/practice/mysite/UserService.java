package com.example.practice.mysite;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    // 1. Create
    @Transactional
    public User createUser(User newUser){
        return userRepository.save(newUser);
    }

    // 2. Read
    // 전체 조회
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    // 단일 조회
    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 id값입니다"));
    }

    // 3. Update
    @Transactional
    public User updateUser(Long id, User updatedUser){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 id값입니다"));

        user.update(updatedUser);
        return user;
    }

    // 4. Delete
    @Transactional
    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 id값입니다"));

        userRepository.delete(user);
    }

}
