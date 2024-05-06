package com.fastcampus.Board_Huge_Traffic_Handling.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    public enum SortStatus {
        CATEGORIES, NEWEST, OLDDEST
    }

    private int id;
    private String name;
    private SortStatus sortStatus;
    private int searchCount;
    private int pagingStartOffset;

}
