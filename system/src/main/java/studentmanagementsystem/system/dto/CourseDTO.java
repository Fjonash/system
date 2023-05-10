package studentmanagementsystem.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private int courseId;

    @NotBlank(message = "Name is required")
    private String name;

    private String major;
    private String minor;
    private String location;
    private String schedule;
    private int year;

    @NotBlank(message = "Offered semester is required")
    private int semester;



}