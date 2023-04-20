package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";

    }

    /*@GetMapping("/new"")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";

    }*/
}
