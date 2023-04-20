package service.impl;

import entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CourseRepository;

import java.util.List;


@Service
public class CourseService
{
    @Autowired
    private CourseRepository repo;
    public List<Course> listAll() {
        return repo.findAll();
    }

    public void save(Course course) {
        repo.save(course);
    }

    public Course get(long id) {
        return repo.findById((int) id).get();
    }

    public void delete(long id) {
        repo.deleteById((int) id);
    }

}
