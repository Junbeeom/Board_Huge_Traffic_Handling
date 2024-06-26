package com.fastcampus.Board_Huge_Traffic_Handling.service.impl;

import com.fastcampus.Board_Huge_Traffic_Handling.dto.PostDTO;
import com.fastcampus.Board_Huge_Traffic_Handling.dto.request.PostSearchRequest;
import com.fastcampus.Board_Huge_Traffic_Handling.exception.BoardServerException;
import com.fastcampus.Board_Huge_Traffic_Handling.mapper.PostSearchMapper;
import com.fastcampus.Board_Huge_Traffic_Handling.service.PostSearchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Log4j2
public class PostSearchServiceImpl implements PostSearchService {
    @Autowired
    private PostSearchMapper postSearchMapper;

    @Cacheable(value = "getPosts", key = "'getPosts' + #postSearchRequest.getName() + #postSearchRequest.getCategoryId()")
    @Override
    public List<PostDTO> getPosts(PostSearchRequest postSearchRequest) {
        List<PostDTO> postDTOList = null;
        try {
            postDTOList = postSearchMapper.selectPosts(postSearchRequest);

        } catch(RuntimeException e) {
            log.error("selectPosts 메서드 실패", e.getMessage());
            throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }


        return postDTOList;
    }

    @Override
    public List<PostDTO> getPostByTag(String tagName) {
        List<PostDTO> postDTOList = null;
        try {
            postDTOList = postSearchMapper.getPostByTag(tagName);
        } catch (RuntimeException e) {
            log.error("selectPosts 실패");
        }

        return postDTOList;
    }


}
