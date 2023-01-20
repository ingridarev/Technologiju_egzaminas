package lt.techin.egzaminas.Service;

import lt.techin.egzaminas.Model.Comment;
import lt.techin.egzaminas.dao.CommentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getById(Long id) {
        return commentRepository.findById(id);
    }


    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }
}
