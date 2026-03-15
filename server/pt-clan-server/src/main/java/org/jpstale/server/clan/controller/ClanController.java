package org.jpstale.server.clan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 公会系统 HTTP 入口，替代 ASP ClanSystem。
 * 后续对接 pt-dao 的 clandb：ClMapper、UlMapper、CtMapper、LiMapper、ClanListMapper 等。
 */
@RestController
@RequestMapping("/clan")
public class ClanController {

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> info() {
        return ResponseEntity.ok(Map.of(
                "app", "pt-clan-server",
                "description", "公会系统 (ClanSystem)"
        ));
    }
}
