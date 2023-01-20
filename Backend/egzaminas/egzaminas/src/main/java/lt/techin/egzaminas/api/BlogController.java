package lt.techin.egzaminas.api;

import lt.techin.egzaminas.Model.Blog;
import lt.techin.egzaminas.Service.BlogService;
import lt.techin.egzaminas.api.dto.BlogDto;
import lt.techin.egzaminas.api.dto.BlogEntityDto;
import lt.techin.egzaminas.api.dto.Mapper.BlogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.egzaminas.api.dto.Mapper.BlogMapper.toBlog;
import static lt.techin.egzaminas.api.dto.Mapper.BlogMapper.toBlogDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/blogs")
public class BlogController {

    public static Logger logger = LoggerFactory.getLogger(BlogController.class);

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public List<BlogEntityDto> getBlogs() {
        return blogService.getAll().stream()
                .map(BlogMapper::toBlogEntityDto)
                .collect(toList());
    }

    @GetMapping(value = "/{blogId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Blog> getBlog(@PathVariable Long blogId) {
        var blogOptional = blogService.getById(blogId);

        var responseEntity = blogOptional
                .map(blog -> ok(blog))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long blogId) {
        logger.info("Attempt to delete Blog by id: {}", blogId);

        boolean deleted = blogService.deleteById(blogId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<BlogDto> createBlog(@RequestBody BlogDto blogDto) {
        var createdBlog = blogService.create(toBlog(blogDto));

        return ok(toBlogDto(createdBlog));
    }

    @PutMapping("/{blogId}")
    public ResponseEntity<BlogDto> replaceBlog(@PathVariable Long blogId, @RequestBody BlogDto blogDto) {
        var updatedBlog = blogService.replace(blogId, toBlog(blogDto));

        return ok(toBlogDto(updatedBlog));
    }

    @PatchMapping("/{blogId}")
    public ResponseEntity<BlogDto> updateBlog(@PathVariable Long blogId, @RequestBody BlogDto blogDto) {
        var updatedBlog = blogService.update(blogId, toBlog(blogDto));

        return ok(toBlogDto(updatedBlog));
    }
}