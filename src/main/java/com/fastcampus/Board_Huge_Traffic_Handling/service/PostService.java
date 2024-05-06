package com.fastcampus.Board_Huge_Traffic_Handling.service;

import com.fastcampus.Board_Huge_Traffic_Handling.dto.PostDTO;

import java.util.List;

public interface PostService {
    void register(String id, PostDTO postDTO);
    List<PostDTO> getMtPosts(int accountId);

    void updatePosts(PostDTO postDTO);

    void deletePosts(int userId, int postId);

}
