package com.fastcampus.Board_Huge_Traffic_Handling.dto.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserDeleteId {
    @NonNull
    private String id;
    @NonNull
    private String password;
}
