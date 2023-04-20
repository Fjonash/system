package dao;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private EntityManager entityManager;

    public long saveUser(Student student){
        entityManager.persist(student);
        entityManager.flush();
        return student.getStudentId();
    }

    public Student findStudentById(Long id){
        return (Student) entityManager.createNamedQuery("findStudentById")
                .setParameter("id",id).getSingleResult();
    }

    public List<Student> findStudent(){
        return (List<Student>) entityManager.createNamedQuery("findStudents").getResultList();
    }
}
