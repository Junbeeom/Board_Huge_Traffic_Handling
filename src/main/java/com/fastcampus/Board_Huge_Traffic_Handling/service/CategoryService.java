package com.fastcampus.Board_Huge_Traffic_Handling.service;

import com.fastcampus.Board_Huge_Traffic_Handling.dto.CategoryDTO;

public interface CategoryService {
    void register(String accountId, CategoryDTO categoryDTO);

    void update(CategoryDTO categoryDTO);

    void delete(int categoryId);
}
