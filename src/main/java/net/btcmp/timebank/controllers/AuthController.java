package net.btcmp.timebank.controllers;

import net.btcmp.timebank.dto.AuthenticatedUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {
    @PostMapping("/authorizations/me")
    public Map<String, Object> onAuthorization(@AuthenticationPrincipal AuthenticatedUserDto user) {
        return Map.of("login", user.getUsername(), "phone", user.getPhone(), "id", user.getId());
    }

    @RequestMapping("/authorizations/unauthorized")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, Object> onUnauthorized() {
        return Map.of("status", HttpStatus.UNAUTHORIZED.value());
    }

}
