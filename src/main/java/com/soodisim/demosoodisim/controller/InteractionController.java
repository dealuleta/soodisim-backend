package com.soodisim.demosoodisim.controller;

import com.soodisim.demosoodisim.model.Interaction;
import com.soodisim.demosoodisim.service.InteractionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interactions")
public class InteractionController {

    private final InteractionService interactionService;

    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @PostMapping
    public Interaction addInteraction(@RequestParam Long userId,
                                      @RequestParam Long postId,
                                      @RequestParam String type) {
        return interactionService.addInteraction(userId, postId, type);
    }
}