package studentmanagementsystem.system.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long commentId;
    private long courseId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "name")
    private String name;

 //  @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "studentId", referencedColumnName = "StudentId")
  //private Student student;
   //@ManyToOne(fetch = FetchType.LAZY)
   //@JoinColumn(name = "courseId", referencedColumnName = "CourseId", insertable = false, updatable = false)
   //private Course course;

    public Comment(long commentId, long courseId, String comment, String name) {
        this.commentId = commentId;
        this.courseId = courseId;
        this.comment = comment;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " : " + comment;
    }
}
