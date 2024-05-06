package com.fastcampus.Board_Huge_Traffic_Handling.mapper;

import com.fastcampus.Board_Huge_Traffic_Handling.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserProfileMapper {
    public UserDTO getUserProfile(@Param("userId") String id);

    int insertUserProfile(@Param("id") String userId, @Param("password") String password,
                          @Param("name") String name, @Param("createTime") String createTime,
                          @Param("updateTime") String updateTime);

    int deleteUserProfile(@Param("id") String id);

    public UserDTO findByUserIdAndPassword(@Param("userId") String userId,
                                           @Param("password") String password);

    int idCheck(@Param("userId") String id);

    public int updatePassword(UserDTO user);

    public int updateAddress(UserDTO user);

    int register(UserDTO userProfile);
}
