package studentmanagementsystem.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentmanagementsystem.system.entity.Course;
import studentmanagementsystem.system.repository.CourseRepository;

import java.util.List;


@Service
public class CourseService
{
    @Autowired
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        super();
        this.courseRepository = courseRepository;
    }
    public List<Course> listAll() {
        return courseRepository.findAll();
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    public Course get(long id) {
        return courseRepository.findById((int) id).get();
    }

    public void delete(long id) {
        courseRepository.deleteById((int) id);
    }

}
