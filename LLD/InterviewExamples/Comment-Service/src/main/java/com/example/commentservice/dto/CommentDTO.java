package com.example.commentservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {

    private String content;
    private Long user_id;
}
