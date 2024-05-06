package com.fastcampus.Board_Huge_Traffic_Handling.mapper;

import com.fastcampus.Board_Huge_Traffic_Handling.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {

    public int register(CategoryDTO categoryDTO);

    public void updateCategory(CategoryDTO categoryDTO);

    public void deleteCategory(int categoryId);
}
