package com.fastcampus.Board_Huge_Traffic_Handling.mapper;

import com.fastcampus.Board_Huge_Traffic_Handling.dto.PostDTO;
import com.fastcampus.Board_Huge_Traffic_Handling.dto.request.PostSearchRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostSearchMapper {
    public List<PostDTO> selectPosts(PostSearchRequest postSearchRequest);

    public List<PostDTO> getPostByTag(String tagName);
}
