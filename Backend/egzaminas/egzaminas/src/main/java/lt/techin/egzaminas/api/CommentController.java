package lt.techin.egzaminas.api;

import jakarta.validation.Valid;
import lt.techin.egzaminas.Service.CommentService;
import lt.techin.egzaminas.api.dto.CommentDto;
import lt.techin.egzaminas.api.dto.CommentEntityDto;
import lt.techin.egzaminas.api.dto.Mapper.CommentMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.egzaminas.api.dto.Mapper.CommentMapper.*;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/comments")
@Validated
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    @ResponseBody
    public List<CommentEntityDto> getComments() {
        return commentService.getAll().stream()
                .map(CommentMapper::toCommentEntityDto)
                .collect(toList());
    }
    @GetMapping("/{commentId}")
    public ResponseEntity<CommentEntityDto> getComment(@PathVariable Long commentId) {
        var commentOptional = commentService.getById(commentId);

        var responseEntity = commentOptional
                .map(comment -> ok(toCommentEntityDto(comment)))
                .orElseGet(() -> ResponseEntity.notFound().build());
        return responseEntity;
    }


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CommentDto> createComment(@Valid @RequestBody CommentDto commentDto) {
        var createdComment = commentService.create(toComment(commentDto));

        return ok(toCommentDto(createdComment));
    }


    }