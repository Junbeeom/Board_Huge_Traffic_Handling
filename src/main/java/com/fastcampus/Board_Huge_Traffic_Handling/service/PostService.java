package com.fastcampus.Board_Huge_Traffic_Handling.service;

import com.fastcampus.Board_Huge_Traffic_Handling.dto.CommentDTO;
import com.fastcampus.Board_Huge_Traffic_Handling.dto.PostDTO;
import com.fastcampus.Board_Huge_Traffic_Handling.dto.TagDTO;

import java.util.List;

public interface PostService {
    void register(String id, PostDTO postDTO);
    List<PostDTO> getMtPosts(int accountId);

    void updatePosts(PostDTO postDTO);

    void deletePosts(int userId, int postId);

    void registerComment(CommentDTO commentDTO);

    void updateComment(CommentDTO commentDTO);

    void deletePostComment(int userId, int commentId);

    void registerTag(TagDTO tagDTO);

    void updateTag(TagDTO tagDTO);

    void deletePostTag(int userId, int tagId);

}
