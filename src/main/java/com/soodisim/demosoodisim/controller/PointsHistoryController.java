package com.soodisim.demosoodisim.controller;

import com.soodisim.demosoodisim.model.PointsHistory;
import com.soodisim.demosoodisim.service.PointsHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/points")
public class PointsHistoryController {

    private final PointsHistoryService service;

    public PointsHistoryController(PointsHistoryService service) {
        this.service = service;
    }

    @PostMapping
    public PointsHistory add(@RequestParam Long userId,
                             @RequestParam int points,
                             @RequestParam String reason) {
        return service.addPoints(userId, points, reason);
    }

    @GetMapping("/{userId}")
    public List<PointsHistory> get(@PathVariable Long userId) {
        return service.getHistory(userId);
    }
}
