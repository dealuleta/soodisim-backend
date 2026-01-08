package com.soodisim.demosoodisim.repository;

import com.soodisim.demosoodisim.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCity_CityId(Long cityId);
    List<Post> findByUser_UserId(Long userId);
}