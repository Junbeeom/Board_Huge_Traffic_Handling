package com.fastcampus.Board_Huge_Traffic_Handling.service;

import com.fastcampus.Board_Huge_Traffic_Handling.dto.UserDTO;

public interface UserService {
    void register(UserDTO userProfile);

    UserDTO login(String id, String password);

    boolean isDuplicatedId(String id);

    UserDTO getUserInfo(String userId);

    void updatePassword(String id, String beforePassword, String afterPassword);

    void deleteId(String id, String password);
}
