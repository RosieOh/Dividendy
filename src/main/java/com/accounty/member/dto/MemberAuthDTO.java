package com.accounty.member.dto;

import com.accounty.member.domain.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

public class MemberAuthDTO {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder(toBuilder = true)
    @ToString
    public static class SignIn {
        @NotBlank(message = "아이디를 입력해주세요.")
        private String username;

        @NotBlank(message = "패스워드를 입력해주세요.")
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder(toBuilder = true)
    @ToString
    public static class SignUp {
        @NotBlank(message = "아이디를 입력해주세요.")
        private String username;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        private String password;

        private List<String> roles;

        public Member toEntity() {
            return Member.builder()
                    .username(username)
                    .password(password)
                    .roles(roles)
                    .build();
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    @ToString
    public static class Response {
        private String username;
    }

}
