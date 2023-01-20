package lt.techin.egzaminas.api.dto;

import java.util.Date;
import java.util.Objects;

public class BlogDto {

    private String title;

    private String content;
    private Date publishingDate;

    public BlogDto(){}

    public BlogDto(String title, String content, Date publishingDate) {
        this.title = title;
        this.content = content;
        this.publishingDate = publishingDate;
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
        BlogDto blogDto = (BlogDto) o;
        return Objects.equals(title, blogDto.title) && Objects.equals(content, blogDto.content) && Objects.equals(publishingDate, blogDto.publishingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, publishingDate);
    }

    @Override
    public String toString() {
        return "BlogDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishingDate=" + publishingDate +
                '}';
    }
}
