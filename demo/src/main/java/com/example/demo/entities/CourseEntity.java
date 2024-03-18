package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "COURSE")

public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "assignments", nullable = false)//yes, no
    private String assignments;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false)
    private Level level;

//    @Column(name = "course_external_id", nullable = false, unique = true)
//    private UUID courseExternalId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity users;


}
