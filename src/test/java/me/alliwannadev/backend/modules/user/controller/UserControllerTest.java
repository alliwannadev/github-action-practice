package me.alliwannadev.backend.modules.user.controller;

import me.alliwannadev.backend.modules.user.domain.User;
import me.alliwannadev.backend.modules.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired UserService userService;

    @BeforeEach
    void beforeEach() {
        userService.createNewUser(
                User.of(
                        "alliwannadev@test.com",
                        "123456",
                        "테스터",
                        "01011112222"
                )
        );
    }

    @DisplayName("[API][GET][SUCCESS] 회원 리스트 조회 API 호출")
    @Test
    void callTestApi_success() throws Exception {
        // Given
        String url = "/api/v1/users";

        // When & Then
        mockMvc.perform(
                        get(url)
                                .contentType(APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].userId").value("1"))
                .andExpect(jsonPath("$[0].email").value("alliwannadev@test.com"))
                .andExpect(jsonPath("$[0].name").value("테스터"))
                .andReturn();
    }
}