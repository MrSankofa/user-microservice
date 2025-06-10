package com.altruisicsoftwaredevelopment.spring.user_microservice.controller;

import com.altruisicsoftwaredevelopment.spring.user_microservice.entity.User;
import com.altruisicsoftwaredevelopment.spring.user_microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<?> getUserById(@PathVariable Long id) {
    User user = userService.getUserById(id);
    return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
  }

  @GetMapping("/username/{username}")
  public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
    User user = userService.getUserByUsername(username);
    return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<?> createUser(@RequestBody User user) {
    try {
      User newUser = userService.createNewUser(user);
      return ResponseEntity.created(URI.create("/user/" + newUser.getId())).body(newUser);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error creating user: " + e.getMessage());
    }
  }

  @PatchMapping
  public ResponseEntity<?> updateUser(@RequestBody User user) {
    try {
      return ResponseEntity.ok(userService.updateUser(user));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error updating user: " + e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable Long id) {
    try {
      userService.deleteUser(id);
      return ResponseEntity.ok("User with ID " + id + " deleted");
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Error deleting user: " + e.getMessage());
    }
  }
}
