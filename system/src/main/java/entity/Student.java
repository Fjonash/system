package entity;

import javax.persistence.*;

@Entity
@Table (name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "year_nr")
    private int year;

    @Column(name = "major")
    private String major;

    @Column(name = "minor")
    private String minor;
    @Column(name = "fisrt_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    public Student(){

    }

    public Student(long studentId, int year, String major, String minor, String firstName, String lastName, int age, String email, String password) {
        this.studentId = studentId;
        this.year = year;
        this.major = major;
        this.minor = minor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + " years old) \n"
                + "Year " + year + ". Major '" + major + "' and minor '" + minor + "'\n"
                + "Email: " + email;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public String getMinor() {
        return minor;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }


}
