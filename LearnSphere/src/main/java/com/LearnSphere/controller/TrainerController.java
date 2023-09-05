package com.LearnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LearnSphere.entity.Course;
import com.LearnSphere.entity.Lesson;
import com.LearnSphere.services.TrainerService;

@Controller
public class TrainerController {
	@Autowired
	TrainerService tService;
@PostMapping("/addcourse")
public String addcourse(@RequestParam("courseId")int courseId,
		@RequestParam("courseName")String courseName,
		@RequestParam("coursePrice")int coursePrice) {
	Course course=new Course();
	course.setCourseId(courseId);
	course.setCourseName(courseName);
	course.setCoursePrice(coursePrice);
	tService.addcourse(course);
	return "redirect:/";
	
}
@PostMapping("/lesson")
public String addcourse(@RequestParam("courseId")int courseId,
		@RequestParam("lessonId")int lessonId,
		@RequestParam("lessonName")String lessonName,
		@RequestParam("topics")String topics,
		@RequestParam("link")String link) {
	
	Course course=tService.getCourse(courseId);
	
	Lesson lesson=new Lesson(lessonId,lessonName,topics,link,course);
	tService.addLesson(lesson);
	
    course.getLessons().add(lesson);	
	return "redirect:/";
	
}
 @GetMapping("/showCourses")
 public String showCourses(Model model) {
	 List<Course>  courseList=tService.courseList();
	 model.addAttribute("courseList",courseList);
	 System.out.println(courseList);
	 return "courses";
 }
}

