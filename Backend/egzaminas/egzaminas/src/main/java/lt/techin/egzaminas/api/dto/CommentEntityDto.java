package lt.techin.egzaminas.api.dto;

import java.util.Objects;

public class CommentEntityDto extends CommentDto{

    private Long id;


    public CommentEntityDto(){}

    public CommentEntityDto(Long id, String author, String text) {
        super(author, text);
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
        CommentEntityDto that = (CommentEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "CommentEntityDto{" +
                "id=" + id +
                '}';
    }
}
