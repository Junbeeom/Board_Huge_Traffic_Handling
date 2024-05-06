package com.fastcampus.Board_Huge_Traffic_Handling.mapper;

import com.fastcampus.Board_Huge_Traffic_Handling.dto.TagDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {

    public int register(TagDTO tagDTO);

    public void updateTags(TagDTO tagDTO);

    public void deletePostTag(int tagId);

    public void createPostTag(Integer tagId, Integer postId);
}
