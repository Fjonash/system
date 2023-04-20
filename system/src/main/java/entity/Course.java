package entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "COURSE")
@NamedQueries({
        @NamedQuery(name = "findCourseById",
                query ="SELECT c FROM Course AS c WHERE c.id = :id" ),
        @NamedQuery(name = "findCourses", query = "SELECT c FROM Course AS c")
})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long courseId;

    @NotBlank(message = "Name is required")
    @Column(name = "NAME")
    private String name;

    @Column(name = "major")
    private String major;

    @Column(name = "minor")
    private String minor;

    @Column(name = "location")
    private String location;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "year")
    private int year;

    @NotBlank(message = "Offered semester is required")
    @Column(name = "SEMESTER_OFFERED")
    private int semester;

    @Column(name = "duration")
    private int duration;

    public Course(long courseId, String name, String major, String minor, String location, String schedule, int year, int semester, int duration) {
        this.courseId = courseId;
        this.name = name;
        this.major = major;
        this.minor = minor;
        this.location = location;
        this.schedule = schedule;
        this.year = year;
        this.semester = semester;
        this.duration = duration;
    }

    public Course() {

    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }

    public long getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }


    public Long getId() {
        return null;
    }
}
