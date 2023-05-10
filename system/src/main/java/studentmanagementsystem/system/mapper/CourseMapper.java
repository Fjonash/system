package studentmanagementsystem.system.mapper;

import studentmanagementsystem.system.dto.CourseDTO;
import studentmanagementsystem.system.entity.Course;

public class CourseMapper {

    public static CourseDTO toDto(Course course) {
        return CourseDTO.builder()
                .courseId(course.getCourseId())
                .name(course.getName())
                .major(course.getMajor())
                .minor(course.getMinor())
                .location(course.getLocation())
                .schedule(course.getSchedule())
                .year(course.getYear())
                .semester(course.getSemester())
                .build();
    }
    public static CourseDTO toEntity(CourseDTO courseDTO){
        return CourseDTO.builder()
                .courseId(courseDTO.getCourseId())
                .name(courseDTO.getName())
                .major(courseDTO.getMajor())
                .minor(courseDTO.getMinor())
                .location(courseDTO.getLocation())
                .schedule(courseDTO.getSchedule())
                .year(courseDTO.getYear())
                .semester(courseDTO.getSemester())
                .build();
    }

}
