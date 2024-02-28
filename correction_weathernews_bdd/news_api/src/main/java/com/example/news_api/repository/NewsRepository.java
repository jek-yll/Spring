package com.example.news_api.repository;

import com.example.news_api.entity.News;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends R2dbcRepository<News, Integer> {
}
