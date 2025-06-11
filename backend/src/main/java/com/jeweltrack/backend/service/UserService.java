package com.jeweltrack.backend.service;

import com.jeweltrack.backend.model.User;
import com.jeweltrack.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public User registerUser(User user) throws Exception {
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            throw new Exception("User with this email already exists.");
        }
        return userRepository.save(user);
    }

    // Login - return user if credentials match
    public User loginUser(String email, String password) throws Exception {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            throw new Exception("No user found with this email.");
        }

        User user = userOpt.get();
        if (!user.getPassword().equals(password)) {
            throw new Exception("Incorrect password.");
        }

        return user;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
}

}
