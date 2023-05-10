package studentmanagementsystem.system.repository;

import org.springframework.data.jpa.repository.Query;
import studentmanagementsystem.system.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>
{
    @Query("select c from Course c")
    List<Course> findAllCourses();

}
