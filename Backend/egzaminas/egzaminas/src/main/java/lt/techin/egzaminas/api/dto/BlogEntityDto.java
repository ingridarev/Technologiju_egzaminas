package lt.techin.egzaminas.api.dto;

import java.util.Date;
import java.util.Objects;

public class BlogEntityDto extends BlogDto {

    private Long id;

    public BlogEntityDto(){}

    public BlogEntityDto(Long id) {
        this.id = id;
    }

    public BlogEntityDto(String title, String content, Date publishingDate) {
        super(title, content, publishingDate);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BlogEntityDto that = (BlogEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "BlogEntityDto{" +
                "id=" + id +
                '}';
    }
}
