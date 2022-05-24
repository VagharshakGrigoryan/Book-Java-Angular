package com.example.bookbackend.repository;

import com.example.bookbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@Repository
@RestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Long> {
}
