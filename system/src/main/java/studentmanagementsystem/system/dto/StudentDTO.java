package studentmanagementsystem.system.dto;


import studentmanagementsystem.system.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long studentId;
    private int year;
    private String major;
    private String minor;
    @NotEmpty(message = "Name is required")
    private String firstName;
    @NotEmpty(message = "Surname is required")
    private String lastName;
    @Email(message = "Not valid email")
    private String email;
    @NotEmpty(message = "Password is required")
    private String password;
    private Boolean enabled;
    private List<Course> courses;
}