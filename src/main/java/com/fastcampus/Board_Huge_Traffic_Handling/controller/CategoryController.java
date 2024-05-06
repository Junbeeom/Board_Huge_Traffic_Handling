package com.fastcampus.Board_Huge_Traffic_Handling.controller;

import com.fastcampus.Board_Huge_Traffic_Handling.aop.LoginCheck;
import com.fastcampus.Board_Huge_Traffic_Handling.dto.CategoryDTO;
import com.fastcampus.Board_Huge_Traffic_Handling.service.impl.CategoryServiceImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@Log4j2
public class CategoryController {

    private CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @LoginCheck(type = LoginCheck.UserType.ADMIN)
    public void registerCategory(String accountId, @RequestBody CategoryDTO categoryDTO) {
        categoryService.register(accountId, categoryDTO);
    }

    @PatchMapping("{categoryId}")
    @LoginCheck(type = LoginCheck.UserType.ADMIN)
    public void updateCategories(String accountId,
                                 @PathVariable(name="categoryId") int categoryId,
                                 @RequestBody CategoryRequest categoryRequest) {
        CategoryDTO categoryDTO = new CategoryDTO(categoryId, categoryRequest.getName(), CategoryDTO.SortStatus.NEWEST, 10, 1);
        categoryService.update(categoryDTO);

    }

    @DeleteMapping("{categoryId}")
    @LoginCheck(type = LoginCheck.UserType.ADMIN)
    public void deleteCategories(String accountId,
                                 @PathVariable(name="categoryId") int categoryId) {
        categoryService.delete(categoryId);
    }

    //request 객체
    @Getter
    @Setter
    private static class CategoryRequest {
        private int id;
        private String name;
    }


}