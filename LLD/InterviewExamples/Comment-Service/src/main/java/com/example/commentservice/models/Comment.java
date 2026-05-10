package com.example.commentservice.models;

import com.example.commentservice.enums.Comment_Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="comments")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String content;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private int like_count = 0;

    @Enumerated(EnumType.STRING)
    private Comment_Status status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Comment(User user, String content) {
        this.user = user;
        this.content = content;
        this.status = Comment_Status.ACTIVE;

    }


}
