package com.LearnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LearnSphere.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer>{

}
