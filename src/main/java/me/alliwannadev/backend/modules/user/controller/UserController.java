package me.alliwannadev.backend.modules.user.controller;

import lombok.RequiredArgsConstructor;
import me.alliwannadev.backend.modules.user.domain.User;
import me.alliwannadev.backend.modules.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/api/v1/users")
    public List<User> getUserList() {
        List<User> userList = userService.getUserList();
        return userList;
    }
}
