package org.jpstale.server.web.controller;

import jakarta.validation.Valid;
import org.jpstale.server.web.dto.RegisterRequest;
import org.jpstale.server.web.dto.RegisterResponse;
import org.jpstale.server.web.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册 HTTP 接口：创建账号、初始化密码（写入 userdb.user_info）。
 */
@RestController
@RequestMapping("/api")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request) {
        RegisterResponse response = registerService.register(
                request.getAccount(), request.getEmail(), request.getPassword());
        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }
}
