package com.example.demo.controllers;

import com.example.demo.controllers.dtos.CourseDtos.CourseDto;
import com.example.demo.services.CourseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDto>> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @PostMapping
    public ResponseEntity<CourseDto>addCourse(@RequestBody CourseDto courseDto){
        try {
            CourseDto addedCourse = courseService.addCourse(courseDto);
            return ResponseEntity.ok(addedCourse);
        }
        catch (RuntimeException e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/courseById")
    public ResponseEntity<CourseDto> findById(@RequestParam("id") Integer courseId) {
        try{
            CourseDto courseDto = courseService.findById(courseId);
            return ResponseEntity.ok(courseDto);
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/update-rating")
    public ResponseEntity<CourseDto> updateCourse(@RequestParam("title") String title, @RequestParam("rating") int rating){
        try {
            CourseDto updatedCourse = courseService.updateCourse(title, rating);
            return ResponseEntity.ok(updatedCourse);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCourse(@RequestParam("title") String title) {
        try {
            courseService.deleteCourse(title);
            return ResponseEntity.noContent().build(); // Successfully deleted or user not found
        } catch (EntityNotFoundException e) {
            // User not found
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            // Any other exception
            return ResponseEntity.badRequest().build();
        }
    }






}
