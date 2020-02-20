package com.food.guide.dao;

import com.food.guide.domain.Blogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloggerRepository extends JpaRepository<Blogger, Long> {
}
