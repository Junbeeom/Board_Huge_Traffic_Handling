package com.fastcampus.Board_Huge_Traffic_Handling.dto.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {
    @NonNull
    private String userId;
    @NonNull
    private String password;

}
