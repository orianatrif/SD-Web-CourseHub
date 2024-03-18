package com.example.demo.repository;

import com.example.demo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {


    public UserEntity findByFirstname(String name);
}
