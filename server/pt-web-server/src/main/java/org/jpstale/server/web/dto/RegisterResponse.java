package org.jpstale.server.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {

    private boolean success;
    private String message;

    public static RegisterResponse ok(String message) {
        return new RegisterResponse(true, message);
    }

    public static RegisterResponse fail(String message) {
        return new RegisterResponse(false, message);
    }
}
