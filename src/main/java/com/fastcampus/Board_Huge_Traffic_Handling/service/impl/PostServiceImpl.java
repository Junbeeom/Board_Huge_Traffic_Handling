package com.fastcampus.Board_Huge_Traffic_Handling.service.impl;

import com.fastcampus.Board_Huge_Traffic_Handling.dto.CommentDTO;
import com.fastcampus.Board_Huge_Traffic_Handling.dto.PostDTO;
import com.fastcampus.Board_Huge_Traffic_Handling.dto.TagDTO;
import com.fastcampus.Board_Huge_Traffic_Handling.dto.UserDTO;
import com.fastcampus.Board_Huge_Traffic_Handling.mapper.CommentMapper;
import com.fastcampus.Board_Huge_Traffic_Handling.mapper.PostMapper;
import com.fastcampus.Board_Huge_Traffic_Handling.mapper.TagMapper;
import com.fastcampus.Board_Huge_Traffic_Handling.mapper.UserProfileMapper;
import com.fastcampus.Board_Huge_Traffic_Handling.service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Log4j2
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private TagMapper tagMapper;

    @Override
    public void register(String id, PostDTO postDTO) {
        UserDTO memberInfo = userProfileMapper.getUserProfile(id);
        postDTO.setUserId(memberInfo.getId());
        postDTO.setCreateTime(new Date());

        if(memberInfo != null) {
            try {
                postMapper.register(postDTO);

                //마지막 AutoIncrement 값을 가져오기 위해서
                Integer postId = postDTO.getId();
                for(int i = 0; i < postDTO.getTagDTOList().size(); i++) {
                    TagDTO tagDTO = postDTO.getTagDTOList().get(i);
                    tagMapper.register(tagDTO);
                    Integer tagId = tagDTO.getId();
                    tagMapper.createPostTag(tagId, postId);
                }
            } catch(RuntimeException e) {
                log.error("register ERROR! {}", postDTO);
                throw new RuntimeException("register ERROR! 게시글 등록 메서드를 확인해주세요" + postDTO);
            }
        } else {
            log.error("register ERROR! {}", postDTO);
            throw new RuntimeException("register ERROR! 게시글 등록 메서드를 확인해주세요" + postDTO);
        }
    }

    @Override
    public List<PostDTO> getMtPosts(int accountId) {
        List<PostDTO> postDtoList = null;
        try {
            postDtoList = postMapper.selectMyPosts(accountId);

        } catch(RuntimeException e) {
            log.error("getMtPosts ERROR! {}", accountId);
            throw new RuntimeException("register ERROR! 게시글 조회 메서드를 확인해주세요" + accountId);
        }
        return postDtoList;
    }

    @Override
    public void updatePosts(PostDTO postDTO) {
        if(postDTO != null && postDTO.getId() != 0) {
            try {
                postMapper.updatePosts(postDTO);

            } catch(RuntimeException e) {
                log.error("updatePosts ERROR! {}", postDTO);
                throw new RuntimeException("updatePosts ERROR! 게시글 수정 메서드를 확인해주세요" + postDTO);
            }
        } else {
            log.error("updatePosts ERROR! {}", postDTO);
            throw new RuntimeException("updatePosts ERROR! 게시글 수정 메서드를 확인해주세요" + postDTO);
        }

    }

    @Override
    public void deletePosts(int userId, int postId) {
        if(userId != 0 && postId != 0) {
            try {
                postMapper.deletePosts(postId);
            } catch(RuntimeException e) {
                log.error("deletePosts ERROR! {}", postId);
                throw new RuntimeException("updatePosts ERROR! 게시글 수정 메서드를 확인해주세요" + postId);
            }
        } else {
            log.error("deletePosts ERROR! {}", postId);
            throw new RuntimeException("updatePosts ERROR! 게시글 수정 메서드를 확인해주세요" + postId);
        }
    }

    @Override
    public void registerComment(CommentDTO commentDTO) {
        if(commentDTO.getPostId() != 0) {
            commentMapper.register(commentDTO);
        } else {
            log.error("registerComment {} ", commentDTO);
            throw new RuntimeException("registerComment" + commentDTO);
        }

    }

    @Override
    public void updateComment(CommentDTO commentDTO) {
        if(commentDTO != null) {
            commentMapper.updateComments(commentDTO);
        } else {
            log.error("updateComment {} error!");
            throw new RuntimeException("updateComment" + commentDTO);
        }

    }

    @Override
    public void deletePostComment(int userId, int commentId) {
        if(userId != 0 && commentId != 0) {
            commentMapper.deletePostComment(commentId);
        } else {
            log.error("deletePostComment error! {} ", commentId);
            throw new RuntimeException("deletePostComment" + commentId);
        }

    }

    @Override
    public void registerTag(TagDTO tagDTO) {
        if(tagDTO != null) {
            tagMapper.register(tagDTO);
        } else {
            log.error("registerTag error! {} ", tagDTO);
            throw new RuntimeException("registerTag" + tagDTO);
        }

    }

    @Override
    public void updateTag(TagDTO tagDTO) {
        if(tagDTO != null) {
            tagMapper.updateTags(tagDTO);
        } else {
            log.error("updateTag error!");
            throw new RuntimeException("updateTag");
        }
    }

    @Override
    public void deletePostTag(int userId, int tagId) {
        if(userId != 0 && tagId != 0) {
            tagMapper.deletePostTag(tagId);
        } else {
            log.error("deletePostTag error!");
            throw new RuntimeException("deletePostTag");
        }
    }
}
