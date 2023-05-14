package studentmanagementsystem.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentmanagementsystem.system.entity.Comment;
import studentmanagementsystem.system.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentService(CommentRepository courseRepository) {
        super();
        this.commentRepository = commentRepository;
    }
    public List<Comment> listAll() {
        return commentRepository.findAll();
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public Comment get(long id) {
        return commentRepository.findById(id).get();
    }


    public void delete(long id) {
        commentRepository.deleteById(id);
    }

}