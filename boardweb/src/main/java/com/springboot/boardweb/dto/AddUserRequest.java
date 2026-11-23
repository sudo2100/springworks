package com.springboot.boardweb.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor  //기본 생성자
@Getter
@Setter
public class AddUserRequest {
    private String username;
    private String password;
}
