package com.altruisicsoftwaredevelopment.spring.user_microservice.repository;

import com.altruisicsoftwaredevelopment.spring.user_microservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
