package org.jpstale.server.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    /** 前端传入的 SHA256 十六进制串（64 字符），与登录格式一致 */
    @NotBlank(message = "密码不能为空")
    @Size(min = 64, max = 64)
    @Pattern(regexp = "[0-9A-Fa-f]{64}", message = "密码格式无效")
    private String password;
}
