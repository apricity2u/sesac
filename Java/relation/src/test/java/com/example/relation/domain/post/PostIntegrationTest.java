package com.example.relation.domain.post;

import com.example.relation.domain.post.dto.PostCreateRequestDto;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.repository.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ActiveProfiles("test")
@SpringBootTest()
@AutoConfigureMockMvc(addFilters = false)  // 시큐리티 필터 비활성화
class PostIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
        postRepository.deleteAll();  // 각 테스트 전 데이터 초기화
    }

    @Test
    void 게시글_생성_테스트() throws Exception {
        // given
        PostCreateRequestDto request = new PostCreateRequestDto(
                "제목입니다",
                "내용입니다",
                "작성자"
        );

        // when
        ResultActions result = mockMvc.perform(
                post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request))

        );

        // then
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.title").value("제목입니다"))
                .andExpect(jsonPath("$.data.content").value("내용입니다"));


        // DB 저장 확인
        List<Post> posts = postRepository.findAll();
        assertThat(posts).hasSize(1);
        assertThat(posts.getFirst().getTitle()).isEqualTo("제목입니다");
    }

    @Test
    void 게시글_단건조회_성공() throws Exception {
        // given
        Post savedPost = postRepository.save(Post.builder()
                .title("제목입니다")
                .content("내용입니다")
                .author("작성자")
                .build());

        // when & then
        mockMvc.perform(get("/posts/" + savedPost.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(savedPost.getId()))
                .andExpect(jsonPath("$.data.title").value("제목입니다"))
                .andExpect(jsonPath("$.data.content").value("내용입니다"))
                .andExpect(jsonPath("$.data.author").value("작성자"));
    }

    @Test
    void 게시글_단건조회_실패_게시글이_없는_경우() throws Exception {
        // given
        Long notExistId = 999L;

        // when & then
        mockMvc.perform(get("/posts/" + notExistId))
                .andExpect(status().isNotFound());
    }
}
