package com.example.commentservice.services;

import com.example.commentservice.dto.CommentDTO;
import com.example.commentservice.enums.Comment_Status;
import com.example.commentservice.models.Comment;
import com.example.commentservice.models.CommentLike;
import com.example.commentservice.models.User;
import com.example.commentservice.repositories.CommentLikeRepository;
import com.example.commentservice.repositories.CommentRepository;
import com.example.commentservice.repositories.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private CommentLikeRepository commentLikeRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository,  CommentLikeRepository commentLikeRepository) {
        this.commentRepository = commentRepository;
        this.commentLikeRepository = commentLikeRepository;
        this.userRepository = userRepository;
    }

    public List<Comment> findAllComments(int offset) {
        Pageable pageable = PageRequest.of(offset,10);
        return this.commentRepository.findAll(pageable).getContent();
    }

    public Comment createComment(CommentDTO commentDTO) {
        Comment comment = new Comment(userRepository.findById(commentDTO.getUser_id()).orElseThrow(() -> new IllegalStateException("User is not present")), commentDTO.getContent());
        return this.commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Comment doesn't exist"));

        if(comment.getStatus() == Comment_Status.DELETED) {
            throw new IllegalStateException("Comment already deleted");
        } else {
            comment.setStatus(Comment_Status.DELETED);
            commentRepository.save(comment);
        }
    }

    public Comment findCommentById(Long id) {
        return this.commentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Comment not found"));
    }

    public void likeComment(Long comment_id, Long user_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalStateException("User not found"));
        Comment comment = commentRepository.findById(comment_id)
                .orElseThrow(() -> new IllegalStateException("Comment not found"));

        if(commentLikeRepository.existsByCommentAndUser(comment, user)) {
            throw new IllegalStateException("User has already liked the comment");
        }

        commentLikeRepository.save(new CommentLike(user, comment));
        comment.setLike_count(comment.getLike_count() + 1);
        commentRepository.save(comment);
    }

    public void unlikeComment(Long comment_id, Long user_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalStateException("User not found"));
        Comment comment = commentRepository.findById(comment_id)
                .orElseThrow(() -> new IllegalStateException("Comment not found"));

        CommentLike like = commentLikeRepository.findByCommentAndUser(comment, user)
                .orElseThrow(() -> new IllegalStateException("User has not liked the comment"));

        commentLikeRepository.deleteById(like.getId());
        comment.setLike_count(comment.getLike_count() - 1);
        commentRepository.save(comment);
    }

    public int getCommentLikeCount(Long comment_id) {
        Comment comment = commentRepository.findById(comment_id).orElseThrow(() -> new IllegalStateException("Comment is not present"));
        return comment.getLike_count();
    }

}
