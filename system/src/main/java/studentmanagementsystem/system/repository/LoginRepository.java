package studentmanagementsystem.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studentmanagementsystem.system.entity.Login;

public interface LoginRepository extends JpaRepository <Login, Long>{
    Login findByUsernameAndPassword(String username, String password);
}
