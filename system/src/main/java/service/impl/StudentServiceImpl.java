package service.impl;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;
import service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

  @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
/*
    public List<Course> searchCourses(String keyword) {
        return studentRepository.searchCourses(keyword);
    }

    public void updateProfile(Student student) {
        studentRepository.save(student);
    }

    public List<Comment> getCommentsByStudentId(Long studentId) {
        return studentRepository.getCommentsByStudentId(studentId);
    }

    public void addComment(Comment comment) {
        studentRepository.addComment(comment);
    }

    public List<Student> getFriends(Long studentId) {
        return studentRepository.getFriends(studentId);
    }

    public List<Student> getRegisteredFriends(Long studentId) {
        return studentRepository.getRegisteredFriends(studentId);
    }

    public List<Course> getFriendCourses(Long friendId) {
        return studentRepository.getFriendCourses(friendId);
    } */
}

