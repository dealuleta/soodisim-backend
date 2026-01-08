package com.soodisim.demosoodisim.service;

import com.soodisim.demosoodisim.model.City;
import com.soodisim.demosoodisim.model.Post;
import com.soodisim.demosoodisim.model.User;
import com.soodisim.demosoodisim.repository.CityRepository;
import com.soodisim.demosoodisim.repository.PostRepository;
import com.soodisim.demosoodisim.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CityRepository cityRepository;

    public PostService(PostRepository postRepository,
                       UserRepository userRepository,
                       CityRepository cityRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.cityRepository = cityRepository;
    }

    public Post createPost(Post post, Long userId, Long cityId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found"));

        post.setUser(user);
        post.setCity(city);

        return postRepository.save(post);
    }

    public List<Post> getPostsByCity(Long cityId) {
        return postRepository.findByCity_CityId(cityId);
    }

    public List<Post> getPostsByUser(Long userId) {
        return postRepository.findByUser_UserId(userId);
    }
}