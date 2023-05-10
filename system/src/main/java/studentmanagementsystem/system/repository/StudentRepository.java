package studentmanagementsystem.system.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentmanagementsystem.system.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>{


}
