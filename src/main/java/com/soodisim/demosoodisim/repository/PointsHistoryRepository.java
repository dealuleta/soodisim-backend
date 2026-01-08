package com.soodisim.demosoodisim.repository;

import com.soodisim.demosoodisim.model.PointsHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointsHistoryRepository extends JpaRepository<PointsHistory, Long> {
    List<PointsHistory> findByUser_UserId(Long userId);
}