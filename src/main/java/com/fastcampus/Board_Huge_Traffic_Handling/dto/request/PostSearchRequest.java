package com.fastcampus.Board_Huge_Traffic_Handling.dto.request;

import com.fastcampus.Board_Huge_Traffic_Handling.dto.CategoryDTO;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostSearchRequest {
    private int id;
    private String name;
    private String contents;
    private int views;
    private int categoryId;
    private int userId;
    private CategoryDTO.SortStatus sortStatus;
}
