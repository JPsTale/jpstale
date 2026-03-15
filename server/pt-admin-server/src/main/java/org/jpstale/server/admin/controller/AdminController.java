package org.jpstale.server.admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 运维管理入口，后续可扩展：账号封禁/解封、公告、数据查询等。
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> info() {
        return ResponseEntity.ok(Map.of(
                "app", "pt-admin-server",
                "description", "运维管理 Web 系统"
        ));
    }
}
