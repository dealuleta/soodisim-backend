package com.soodisim.demosoodisim.service;

import com.soodisim.demosoodisim.model.PointsHistory;
import com.soodisim.demosoodisim.model.User;
import com.soodisim.demosoodisim.repository.PointsHistoryRepository;
import com.soodisim.demosoodisim.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointsHistoryService {

    private final PointsHistoryRepository repo;
    private final UserRepository userRepo;

    public PointsHistoryService(PointsHistoryRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public PointsHistory addPoints(Long userId, int points, String reason) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setPoints(user.getPoints() + points);

        PointsHistory history = new PointsHistory();
        history.setUser(user);
        history.setPoints(points);
        history.setReason(reason);

        return repo.save(history);
    }

    public List<PointsHistory> getHistory(Long userId) {
        return repo.findByUser_UserId(userId);
    }
}