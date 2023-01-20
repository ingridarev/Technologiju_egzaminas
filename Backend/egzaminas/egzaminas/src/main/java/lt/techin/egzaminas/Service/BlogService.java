package lt.techin.egzaminas.Service;

import lt.techin.egzaminas.Model.Blog;
import lt.techin.egzaminas.dao.BlogRepository;
import lt.techin.egzaminas.dao.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository, CommentRepository commentRepository){
        this.blogRepository= blogRepository;
        this.commentRepository = commentRepository;
    }

    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getById(Long id) {
        return blogRepository.findById(id);
    }


    public Blog create(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog update(Long id, Blog blog) {
        var existingBlog = blogRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Blog does not exist "+ id.toString()));

        existingBlog.setTitle(blog.getTitle());
        existingBlog.setContent(blog.getContent());
        existingBlog.setPublishingDate(blog.getPublishingDate());

        return blogRepository.save(existingBlog);
    }

    public Blog replace(Long id, Blog blog) {
        blog.setId(id);

        return blogRepository.save(blog);
    }

    public boolean deleteById(Long id) {
        try {
            blogRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }
}
