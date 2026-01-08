package com.soodisim.demosoodisim.service;

import com.soodisim.demosoodisim.model.Interaction;
import com.soodisim.demosoodisim.model.Post;
import com.soodisim.demosoodisim.model.User;
import com.soodisim.demosoodisim.repository.InteractionRepository;
import com.soodisim.demosoodisim.repository.PostRepository;
import com.soodisim.demosoodisim.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class InteractionService {

    private final InteractionRepository interactionRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public InteractionService(InteractionRepository interactionRepository,
                              UserRepository userRepository,
                              PostRepository postRepository) {
        this.interactionRepository = interactionRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public Interaction addInteraction(Long userId, Long postId, String type) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        if (type.equals("VIEW")) {
            post.setViews(post.getViews() + 1);
            postRepository.save(post);
        }

        Interaction interaction = new Interaction();
        interaction.setUser(user);
        interaction.setPost(post);
        interaction.setType(type);

        return interactionRepository.save(interaction);
    }
}