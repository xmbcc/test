package com.lujiaxin.sop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserInfo {

    private String username;
    private String password;
    private String code;
    private String randomStr;
    private String codeimg;

}
