package lt.techin.egzaminas.api.dto.Mapper;

import lt.techin.egzaminas.Model.Blog;
import lt.techin.egzaminas.api.dto.BlogDto;
import lt.techin.egzaminas.api.dto.BlogEntityDto;

public class BlogMapper {

    public static BlogDto toBlogDto(Blog blog) {
        var blogDto = new BlogDto();

        blogDto.setTitle(blog.getTitle());
        blogDto.setContent(blog.getContent());
        blogDto.setPublishingDate(blog.getPublishingDate());

        return blogDto;
    }

    public static BlogEntityDto toBlogEntityDto(Blog blog) {
        var blogDto = new BlogEntityDto();

        blogDto.setId(blog.getId());
        blogDto.setTitle(blog.getTitle());
        blogDto.setContent(blog.getContent());
        blogDto.setPublishingDate(blog.getPublishingDate());


        return blogDto;
    }

    public static Blog toBlog(BlogDto blogDto) {
        var blog = new Blog();

        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setPublishingDate(blogDto.getPublishingDate());

        return blog;
    }

    public static Blog toBlogFromEntityDto(BlogEntityDto blogDto) {
        var blog = new Blog();

        blog.setId(blogDto.getId());
        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setPublishingDate(blogDto.getPublishingDate());

        return blog;
    }

}
