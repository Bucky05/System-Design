package com.example.commentservice.controllers;

import com.example.commentservice.dto.CommentDTO;
import com.example.commentservice.models.Comment;
import com.example.commentservice.services.CommentService;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) { this.commentService = commentService;}

    @GetMapping
    public List<Comment> getComments(@RequestParam int offset) {
        return commentService.findAllComments(offset);

    }


    @PostMapping
    public Comment createComment(@RequestBody CommentDTO commentDTO) {
        return commentService.createComment(commentDTO);
    }

    @DeleteMapping("/{comment_id}")
    public void deleteComment(@PathVariable Long comment_id) {
        commentService.deleteComment(comment_id);
    }



}
