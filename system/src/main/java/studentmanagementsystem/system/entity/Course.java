package studentmanagementsystem.system.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@Table(name = "course")
@NamedQueries({
        @NamedQuery(name = "findCourseById",
                query ="SELECT c FROM Course AS c WHERE c.id = :id" ),
        @NamedQuery(name = "findCourses", query = "SELECT c FROM Course c")
})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

   @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
   private List<Student> students;

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
                "name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", minor='" + minor + '\'' +
                ", location='" + location + '\'' +
                ", schedule='" + schedule + '\'' +
                ", year=" + year +
                ", semester=" + semester +
                ", duration=" + duration +
                '}';
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public @NotBlank(message = "Offered semester is required") int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
