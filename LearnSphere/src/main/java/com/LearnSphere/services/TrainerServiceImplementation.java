package com.LearnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LearnSphere.entity.Course;
import com.LearnSphere.entity.Lesson;
import com.LearnSphere.repository.CourseRepository;
import com.LearnSphere.repository.LessonRepository;
@Service
public class TrainerServiceImplementation implements TrainerService {
	@Autowired
CourseRepository courseRepo;
	
	@Autowired
	LessonRepository lessonRepo;
	@Override
	public String addcourse(Course course) {
		courseRepo.save(course);
		return "Course added successfully";
	}
	@Override
	public String addLesson(Lesson lesson) {
		lessonRepo.save(lesson);
		return "Lesson added successfully";
	}
	@Override
	public Course getCourse(int courseId) {
		
		return courseRepo.findById(courseId).get();
	}
	@Override
	public List<Course> courseList() {
			return courseRepo.findAll();
	}

}
