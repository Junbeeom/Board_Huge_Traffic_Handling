package com.fastcampus.Board_Huge_Traffic_Handling.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private int id;
    private String name;
    private int isAdmin;
    private String contents;
    private Date createTime;
    private int views;
    private int categoryId;
    private int userId;
    private int fileId;
    private Date updateTime;

    //태그 정보를 위해
    private List<TagDTO> tagDTOList;

}
