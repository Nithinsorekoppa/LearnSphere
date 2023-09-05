package com.LearnSphere.services;

import java.util.List;

import com.LearnSphere.entity.Course;
import com.LearnSphere.entity.Lesson;

public interface TrainerService {
public String addcourse(Course course);
 
public String addLesson(Lesson lesson);

public Course getCourse(int courseId);

public List<Course> courseList();
}
