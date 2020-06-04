package com.sangyeon.resetservice4.interfaces;

import com.sangyeon.resetservice4.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private MovieRepository movieRepository;


    @Test
    @DisplayName("Movie API 작동 여부")
    public void showMovieList() throws Exception {
        mvc.perform(get("/api/movie/?q=harry&len=1&offset=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", startsWith("해리포터")))
                .andExpect(jsonPath("$[0].link", startsWith("https://movie.naver.com/movie/bi/mi/basic.nhn")));
    }

    @Test
    @DisplayName("len params 작동여부")
    public void showMovieListByLen() throws Exception {
        mvc.perform(get("/api/movie?q=해리포터&len=3&offset=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].title", is("<b>해리 포터</b>와 죽음의 성물 - 2부")));
    }

    @Test
    @DisplayName("offset params 작동여부")
    public void showMovieListByOffset() throws Exception {
        mvc.perform(get("/api/movie?q=해리포터&len=3&offset=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].title", is("<b>해리 포터</b>와 혼혈 왕자")));
    }

}