package com.altruisicsoftwaredevelopment.spring.user_microservice.service;


import com.altruisicsoftwaredevelopment.spring.user_microservice.entity.User;
import com.altruisicsoftwaredevelopment.spring.user_microservice.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  public User getUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  public User createNewUser(User user) {
    return userRepository.save(user);
  }

  public User updateUser(User updatedUser) {
    User user = userRepository.findByUsername(updatedUser.getUsername());
    if (user == null) throw new IllegalArgumentException("User not found");
    BeanUtils.copyProperties(updatedUser, user, "id");
    return userRepository.save(user);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}

