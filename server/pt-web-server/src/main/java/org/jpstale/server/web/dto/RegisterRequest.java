package org.jpstale.server.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "账号不能为空")
    @Size(min = 1, max = 32)
    private String account;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "请输入有效的邮箱地址")
    @Size(max = 150)
    private String email;

    @NotBlank(message = "密码不能为空")
    @Size(min = 1, max = 64)
    private String password;
}
