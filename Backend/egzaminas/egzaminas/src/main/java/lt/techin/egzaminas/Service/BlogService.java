package lt.techin.egzaminas.Service;

import lt.techin.egzaminas.Model.Blog;
import lt.techin.egzaminas.dao.BlogRepository;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;

public class BlogService {

    private final BlogRepository blogRepository;


    public BlogService(BlogRepository blogRepository){
        this.blogRepository= blogRepository;
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

        existingBlog.setName(blog.getName());
        existingBlog.setType(blog.getType());
        existingBlog.setDestination(blog.getDestination());

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
