package com.sparta.practice.controller;

import com.sparta.practice.dto.PostRequestDto;
import com.sparta.practice.entity.Post;
import com.sparta.practice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/api/posts")   // 전체 게시글 목록 조회 API
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/api/post/{id}")   // 선택한 게시글 조회 API
    public Post sellectPost(@PathVariable Long id) {
        return postService.sellectPost(id);
    }

    @PostMapping("/api/post")   // 게시글 작성 API
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @PutMapping("/api/post/{id}")   // 게시글 수정 API
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/api/post/{id}")    // 게시글 삭제 API
    public Long deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
