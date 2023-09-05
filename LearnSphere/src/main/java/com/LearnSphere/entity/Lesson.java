package com.LearnSphere.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Lesson {
	@Id
 int lessonId;
 String lessonNmae;
 String topics;
 String link;
 @ManyToOne
 Course course;
public Lesson() {
	super();
	// TODO Auto-generated constructor stub
}
public Lesson(int lessonId, String lessonNmae, String topics, String link, Course course) {
	super();
	this.lessonId = lessonId;
	this.lessonNmae = lessonNmae;
	this.topics = topics;
	this.link = link;
	this.course = course;
}
public int getLessonId() {
	return lessonId;
}
public void setLessonId(int lessonId) {
	this.lessonId = lessonId;
}
public String getLessonNmae() {
	return lessonNmae;
}
public void setLessonNmae(String lessonNmae) {
	this.lessonNmae = lessonNmae;
}
public String getTopics() {
	return topics;
}
public void setTopics(String topics) {
	this.topics = topics;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
@Override
public String toString() {
	return "Lesson [lessonId=" + lessonId + ", lessonNmae=" + lessonNmae + ", topics=" + topics + ", link=" + link
			+ ", course=" + course + "]";
}
 
}
