package com.soodisim.demosoodisim.model;

import jakarta.persistence.*;

@Entity
@Table(name = "points_history")
public class PointsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    private int points;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public PointsHistory() {}

    public Long getHistoryId() { return historyId; }
    public void setHistoryId(Long historyId) { this.historyId = historyId; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}