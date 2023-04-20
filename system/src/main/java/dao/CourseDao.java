package dao;

import entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class CourseDao {

    @Autowired
    private EntityManager entityManager;

    public Long saveCourse(Course course){
        entityManager.persist(course);
        return course.getId();
    }

    public Course findCourseById(Long id){
        return (Course) entityManager.createNamedQuery("findCourseById")
                .setParameter("id",id).getSingleResult();
    }

    public List<Course> findCourses(){
        return (List<Course>) entityManager.createNamedQuery("findCourses").getResultList();
    }
}
