package studentmanagementsystem.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studentmanagementsystem.system.entity.Comment;
import studentmanagementsystem.system.entity.Course;
import studentmanagementsystem.system.entity.Student;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // find comments by course and student
    List<Comment> findByCourseAndStudent(Course course, Student student);

}