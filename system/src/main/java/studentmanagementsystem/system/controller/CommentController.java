package studentmanagementsystem.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import studentmanagementsystem.system.entity.Comment;
import studentmanagementsystem.system.entity.Course;
import studentmanagementsystem.system.entity.Student;
import studentmanagementsystem.system.service.StudentService;
import studentmanagementsystem.system.service.impl.CommentService;
import studentmanagementsystem.system.service.impl.CourseService;

@Controller
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;
    private StudentService studentService;
    private CourseService courseService;

    public CommentController(CommentService commentService,
                             StudentService studentService,
                             CourseService courseService) {
        this.commentService = commentService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    public String listComments(Model model) {
        model.addAttribute("comments", commentService.listAll());
        return "comment";
    }

    @GetMapping("/create_comment")
    public String createCommentForm(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("courses", courseService.listAll());
        return "/create_comment";
    }

    @PostMapping("/add")
    public String saveComment(@ModelAttribute (name = "comment_text") String comment_text,
                              @ModelAttribute (name = "studentId") Long studentId,
                              @ModelAttribute (name = "courseId") Long courseId
                              ) {
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.get(courseId);
        Comment comment = new Comment();
        comment.setComment(comment_text);
        comment.setStudent(student);
        comment.setCourse(course);
        commentService.save(comment);
        return "redirect:/comment";
    }

    @RequestMapping("/edit/{commentId}")
    public String editCommentForm(@PathVariable Long commentId, Model model) {
        Comment comment = commentService.get(commentId);
        model.addAttribute("comment", comment);
        model.addAttribute("selectedStudent", comment.getStudent().getStudentId());
        model.addAttribute("selectedCourse", comment.getCourse().getCourseId());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("courses", courseService.listAll());
        return "edit_comment";

    }
    @RequestMapping("/update/{commentId}")
    public String updateComment(@PathVariable Long commentId,
                                @ModelAttribute (name = "comment_text") String comment_text,
                                @ModelAttribute (name = "studentId") Long studentId,
                                @ModelAttribute (name = "courseId") Long courseId) {
        Comment existingComment = commentService.get(commentId);
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.get(courseId);
        existingComment.setComment(comment_text);
        existingComment.setStudent(student);
        existingComment.setCourse(course);
        commentService.save(existingComment);
        return "redirect:/comment";
    }

    @GetMapping("/delete/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        commentService.delete(commentId);
        return "redirect:/comment";
    }
}