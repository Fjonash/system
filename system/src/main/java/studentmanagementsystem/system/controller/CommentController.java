package studentmanagementsystem.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import studentmanagementsystem.system.entity.Comment;
import studentmanagementsystem.system.service.StudentService;
import studentmanagementsystem.system.service.impl.CommentService;
import studentmanagementsystem.system.service.impl.CourseService;

import javax.validation.Valid;

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
        model.addAttribute("comment", commentService.listAll());
        return "comment";
    }

    @GetMapping("/create_comment")
    public String createCommentForm(Model model) {
        Comment comment = new Comment();
        model.addAttribute("comment", comment);
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("courses", courseService.listAll());
        return "/create_comment";
    }

    @PostMapping
    public String saveComment(@ModelAttribute("comment") @Valid Comment comment,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("students", studentService.getAllStudents());
            model.addAttribute("courses", courseService.listAll());
            return "/create_comment";
        } else {
            commentService.save(comment);
            return "redirect:/comment";
        }
    }

    @RequestMapping("/edit/{commentId}")
    public String editCommentForm(@PathVariable Long commentId, Model model) {
        Comment comment = commentService.get(commentId);
        model.addAttribute("comment", comment);
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("courses", courseService.listAll());
        return "comment/edit";

    }
    @PutMapping("/edit/{courseId}")
    public String updateComment(@PathVariable Long commentId,
                                @ModelAttribute("comment") @Valid Comment comment,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("students", studentService.getAllStudents());
            model.addAttribute("courses", courseService.listAll());
            return "comment/edit";
        } else {
            Comment existingComment = commentService.get(commentId);
            existingComment.setComment(comment.getComment());
            existingComment.setStudent(comment.getStudent());
            existingComment.setCourse(comment.getCourse());
            return "redirect:/comment";
        }
    }

    @GetMapping("/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        commentService.delete(commentId);
        return "redirect:/comment";
    }
}