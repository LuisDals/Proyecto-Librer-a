package com.example.demo.infraestructure.persistence;

import com.example.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, String>{

}
