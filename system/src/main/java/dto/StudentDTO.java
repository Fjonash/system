package dto;

import entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long studentId;
    private int year;
    private String major;
    private String minor;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Surname is required")
    private String surname;
    private int age;
    @Email(message = "Not valid email")
    private String email;
    @NotEmpty(message = "Password is required")
    private String password;
    private String birthday;
    private Boolean enabled;
    private List<Course> courses;
    //private List<EnrolledCourse> enrolledCourses;
}