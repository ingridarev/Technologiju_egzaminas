package lt.techin.egzaminas.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.Objects;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 30)
    private String title;

    private String content;
    private Date publishingDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_id")
    //@JoinColumn(name = "room_id", nullable = true)
    private Comment comment;

    public Blog(){}

    public Blog(Long id, String title, String content, Date publishingDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publishingDate = publishingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return Objects.equals(id, blog.id) && Objects.equals(title, blog.title) && Objects.equals(content, blog.content) && Objects.equals(publishingDate, blog.publishingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, publishingDate);
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishingDate=" + publishingDate +
                '}';
    }
}
