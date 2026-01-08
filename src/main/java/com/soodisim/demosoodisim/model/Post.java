package com.soodisim.demosoodisim.model;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;
    private String description;
    private String mediaUrl;
    private String mediaType;
    private int views = 0;

    // RELATIONSHIPS
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Post() {}

    public Long getPostId() { return postId; }
    public void setPostId(Long postId) { this.postId = postId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getMediaUrl() { return mediaUrl; }
    public void setMediaUrl(String mediaUrl) { this.mediaUrl = mediaUrl; }

    public String getMediaType() { return mediaType; }
    public void setMediaType(String mediaType) { this.mediaType = mediaType; }

    public int getViews() { return views; }
    public void setViews(int views) { this.views = views; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }
}