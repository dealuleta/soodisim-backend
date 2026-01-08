package com.soodisim.demosoodisim.model;

import jakarta.persistence.*;

@Entity
@Table(name = "interactions")
public class Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interactionId;

    private String type; // LIKE or VIEW

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Interaction() {}

    public Long getInteractionId() { return interactionId; }
    public void setInteractionId(Long interactionId) { this.interactionId = interactionId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Post getPost() { return post; }
    public void setPost(Post post) { this.post = post; }
}