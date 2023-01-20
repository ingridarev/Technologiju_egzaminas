package lt.techin.egzaminas.api.dto.Mapper;

import lt.techin.egzaminas.Model.Comment;
import lt.techin.egzaminas.api.dto.CommentDto;
import lt.techin.egzaminas.api.dto.CommentEntityDto;

public class CommentMapper {



    public static CommentDto toCommentDto(Comment comment) {
        var commentDto = new CommentDto();

        commentDto.setAuthor(comment.getAuthor());
        commentDto.setText(comment.getText());


        return commentDto;
    }

    public static Comment toComment(CommentDto commentDto) {
        var comment = new Comment();

        comment.setAuthor(commentDto.getAuthor());
        comment.setText(commentDto.getText());

        return comment;
    }


    public static CommentEntityDto toCommentEntityDto(Comment comment) {
        var commentDto = new CommentEntityDto();

        commentDto.setId(comment.getId());
        commentDto.setAuthor(comment.getAuthor());
        commentDto.setText(comment.getText());

        return commentDto;
    }

    public static Comment toComment(CommentEntityDto commentEntityDto) {
        var comment = new Comment();

        comment.setId(commentEntityDto.getId());
        comment.setAuthor(commentEntityDto.getAuthor());
        comment.setText(commentEntityDto.getText());

        return comment;
    }

}

