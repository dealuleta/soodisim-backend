package com.soodisim.demosoodisim.dto;

public class PostDTO {

    private Long postId;
    private String title;
    private String description;
    private String mediaUrl;
    private String mediaType;
    private int views;
    private Long userId;
    private Long cityId;

    public PostDTO(Long postId, String title, String description,
                   String mediaUrl, String mediaType,
                   int views, Long userId, Long cityId) {
        this.postId = postId;
        this.title = title;
        this.description = description;
        this.mediaUrl = mediaUrl;
        this.mediaType = mediaType;
        this.views = views;
        this.userId = userId;
        this.cityId = cityId;
    }

    public Long getPostId() { return postId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getMediaUrl() { return mediaUrl; }
    public String getMediaType() { return mediaType; }
    public int getViews() { return views; }
    public Long getUserId() { return userId; }
    public Long getCityId() { return cityId; }
}