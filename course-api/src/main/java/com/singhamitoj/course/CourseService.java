package com.singhamitoj.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId)
	{
		return (List<Course>) courseRepository.findByTopicId(topicId);
	}
	
	public Course getCourse(String id)
	{
		return courseRepository.findOne(id);
	}
	public void addCourse(Course topic) {
	
		courseRepository.save(topic);
	}
	public void updateCourse(String id,Course topic) {
		
		courseRepository.save(topic);
	}

	public void deleteCourse(String id) {
		
		courseRepository.delete(id);
	}
}
