package com.fastcampus.Board_Huge_Traffic_Handling.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private int id;
    private int postId;
    private String contents;
    private int subCommentId;
}
