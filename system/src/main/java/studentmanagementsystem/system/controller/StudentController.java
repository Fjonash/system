package studentmanagementsystem.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import studentmanagementsystem.system.entity.Student;
import studentmanagementsystem.system.service.StudentService;

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

    @GetMapping("/new")
    public String createStudentForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";

    }

    @PostMapping("/add")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/edit/{studentId}")
    public ModelAndView showEditCoursePage(@PathVariable(name = "studentId") Long id) {
        ModelAndView mav = new ModelAndView("edit_student");
        Student student = studentService.getStudentById(id);
        mav.addObject("student", student);
        return mav;

    }
    @PostMapping("/update/{studentId}")
    public String updateStudent(@PathVariable(name = "studentId") Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {

        // get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setStudentId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    // handler method to handle delete student request

    @RequestMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable(name = "studentId") Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
