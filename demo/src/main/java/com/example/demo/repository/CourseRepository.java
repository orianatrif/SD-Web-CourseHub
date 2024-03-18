package com.example.demo.repository;

import com.example.demo.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface CourseRepository extends JpaRepository<CourseEntity, Integer>  {

    public CourseEntity findByTitle(String title);
}
