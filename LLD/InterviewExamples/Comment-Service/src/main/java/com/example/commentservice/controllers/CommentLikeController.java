package com.example.commentservice.controllers;

import com.example.commentservice.dto.CommentLikeDTO;
import com.example.commentservice.services.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments/{comment_id}/likes")
@CrossOrigin(origins = "*")
public class CommentLikeController {

    public CommentService commentService;

    public CommentLikeController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping
    public int getLikeCount(@PathVariable Long comment_id) {
        return commentService.getCommentLikeCount(comment_id);
    }

    @PostMapping
    public void likeComment(@RequestBody CommentLikeDTO commentLikeDTO) {
        commentService.likeComment(commentLikeDTO.getComment_id(),commentLikeDTO.getUser_id());
    }

    @DeleteMapping
    public void unlikeComment(@RequestBody CommentLikeDTO commentLikeDTO) {
        commentService.unlikeComment(commentLikeDTO.getComment_id(),commentLikeDTO.getUser_id());
    }
}
