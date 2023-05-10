package studentmanagementsystem.system.mapper;

import org.springframework.stereotype.Component;
import studentmanagementsystem.system.dto.StudentDTO;
import studentmanagementsystem.system.entity.Student;

@Component
public class StudentMapper {

    public static StudentDTO toDto(Student student) {
    return StudentDTO.builder()
            .studentId(student.getStudentId())
            .year(student.getYear())
            .major(student.getMajor())
            .minor(student.getMinor())
            .firstName(student.getFirstName())
            .lastName(student.getLastName())
            .email(student.getEmail())
            .password(student.getPassword())
            .build();
    }
    public static StudentDTO toEntity(StudentDTO studentDTO){
        return StudentDTO.builder()
                .studentId(studentDTO.getStudentId())
                .year(studentDTO.getYear())
                .major(studentDTO.getMajor())
                .minor(studentDTO.getMinor())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .email(studentDTO.getEmail())
                .password(studentDTO.getPassword())
                .build();
    }


}
