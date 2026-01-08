package com.soodisim.demosoodisim.controller;

import com.soodisim.demosoodisim.dto.PostDTO;
import com.soodisim.demosoodisim.model.Post;
import com.soodisim.demosoodisim.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping
    public Post create(@RequestParam Long userId,
                       @RequestParam Long cityId,
                       @RequestBody Post post) {
        return service.createPost(post, userId, cityId);
    }

    @GetMapping("/city/{cityId}")
    public List<PostDTO> byCity(@PathVariable Long cityId) {
        return service.getPostsByCity(cityId)
                .stream()
                .map(p -> new PostDTO(
                        p.getPostId(),
                        p.getTitle(),
                        p.getDescription(),
                        p.getMediaUrl(),
                        p.getMediaType(),
                        p.getViews(),
                        p.getUser().getUserId(),
                        p.getCity().getCityId()
                ))
                .toList();
    }
}