package lt.techin.egzaminas.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class CommentDto {

    @NotBlank
    @Size(min = 3, max = 30)
    private String author;

    @NotBlank
    @Size(min = 3, max = 30)
    private String text;

    public CommentDto(){}

    public CommentDto(String author, String text) {
        this.author= author;
        this.text=text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDto that = (CommentDto) o;
        return Objects.equals(author, that.author) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, text);
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
