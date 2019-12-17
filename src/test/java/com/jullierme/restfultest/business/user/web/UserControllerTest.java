package com.jullierme.restfultest.business.user.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jullierme.restfultest.business.user.web.dto.UserRequest;
import com.jullierme.restfultest.business.user.web.dto.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    private static final String PATH = "/user";

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserWebService userWebService;

    @Test
    void shouldCreateNewUser() throws Exception {
        //given
        String login = "login";
        String id = "id";
        UserRequest request = UserRequest.builder().login(login).build();
        UserResponse response = UserResponse.builder().login(login).id(id).build();

        doReturn(response).when(userWebService).save(request);

        //when
        ResultActions actualResult = mockMvc.perform(post(PATH)
                .content(objectMapper.writeValueAsString(request))
                .contentType(APPLICATION_JSON)
        );

        //then
        actualResult
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.login", is(login)));
        verify(userWebService).save(request);
    }
}
