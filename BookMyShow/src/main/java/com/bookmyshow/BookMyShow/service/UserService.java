package com.bookmyshow.BookMyShow.service;

import com.bookmyshow.BookMyShow.dto.LoginRequest;
import com.bookmyshow.BookMyShow.dto.UserRequest;
import com.bookmyshow.BookMyShow.entity.User;
import com.bookmyshow.BookMyShow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //register
    public User register(UserRequest userRequest){;
        if(userRepository.existsByEmail(userRequest.getEmail())){
            throw new RuntimeException("Email already exist : "+userRequest.getEmail());
        }

        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .phone(userRequest.getPhone())
                .city(userRequest.getCity())
                .build();

        return userRepository.save(user);
    }

    //login
    public User login(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()->new RuntimeException("User not found with email : "+loginRequest.getEmail()));

        if(!user.getPassword().equals(loginRequest.getPassword())){
            throw new RuntimeException("Invalid Password");
        }

        return user;
    }

    //all users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //get user by ID
    public User getUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not Found with ID : "+userId));
    }
}
