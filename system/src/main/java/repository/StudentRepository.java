package repository;


import entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface StudentRepository extends JpaRepository <Student, Long>{

   /* @Query("SELECT c FROM Course c WHERE LOWER(c.name) LIKE %:keyword% OR LOWER(c.description) LIKE %:keyword%")
    List<Course> searchCourses(@Param("keyword") String keyword);

    @Query("SELECT c FROM Comment c WHERE c.student.id = :studentId")
    List<Comment> getCommentsByStudentId(@Param("studentId") Long studentId);

    @Modifying
    @Query("INSERT INTO Comment (text, student_id) VALUES (:text, :studentId)")
    void addComment(@Param("text") String text, @Param("studentId") Long studentId);

    @Query("SELECT s.friends FROM Student s WHERE s.id = :studentId")
    <getRegisteredFriends>
    @Query("SELECT s.friends FROM Student s WHERE s.id = :studentId")
            List<Student> getFriends(@Param("studentId") Long studentId);

    void getRegisteredFriends();

    List<Student> getRegisteredFriends(Long studentId);

    List<Course> getFriendCourses(Long friendId);

    void addComment(Comment comment); */
}
