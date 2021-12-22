package com.example.IO.repository;


import com.example.IO.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Repository for finding user by email
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where email =?1 ;",nativeQuery = true)
    Optional<User> findUserByEmail(String email);

    @Query(value = "select * from users where id = ?1 ;", nativeQuery = true)
    Optional<User> findUserByUserId(Long id);

}
