package studentmanagementsystem.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import studentmanagementsystem.system.entity.Course;
import studentmanagementsystem.system.service.impl.CourseService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courceService;

    public CourseController(CourseService courceService) {
        super();
        this.courceService = courceService;
    }

    @GetMapping
    public String listCourses(Model model){
        log.info("Courses {} ",courceService.listAll());
        model.addAttribute("listcourse", courceService.listAll());
        return "course";

    }    @GetMapping("/addcourse")
    public String add(Model model) {
        List<Course> listcourse = courceService.listAll();
        model.addAttribute("listcourse", listcourse);
        model.addAttribute("course", new Course());
        return "addcourse";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("course") Course course) {
        courceService.save(course);
        return "redirect:/course";
    }

    @RequestMapping("/edit/{courseId}")
    public ModelAndView showEditCoursePage(@PathVariable(name = "courseId") Long id) {
        ModelAndView mav = new ModelAndView("addcourse");
        Course course = courceService.get(id);
        mav.addObject("course", course);
        return mav;

    }
    @RequestMapping("/delete/{courseId}")
    public String deleteCoursePage(@PathVariable(name = "courseId") Long id) {
        courceService.delete(id);
        return "redirect:/course";
    }



}
