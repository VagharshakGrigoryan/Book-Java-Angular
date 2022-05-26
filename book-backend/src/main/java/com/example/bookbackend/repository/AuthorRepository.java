package com.example.bookbackend.repository;

import com.example.bookbackend.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

//    @Query(value = "SELECT a.author_id, a.first_name, a.last_name from author a " +
//            "WHERE a.first_name LIKE ?1 or a.last_name LIKE ?1 LIMIT 5", nativeQuery = true)
//    List<Author> findByName(@Param("name") String name);

}
