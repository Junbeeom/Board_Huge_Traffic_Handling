package com.fastcampus.Board_Huge_Traffic_Handling.service;

import com.fastcampus.Board_Huge_Traffic_Handling.dto.PostDTO;
import com.fastcampus.Board_Huge_Traffic_Handling.dto.request.PostSearchRequest;

import java.util.List;

public interface PostSearchService {
    List<PostDTO> getPosts(PostSearchRequest postSearchRequest);
}
