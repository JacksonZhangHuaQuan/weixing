package org.lanqiao.dao;

import org.lanqiao.entity.Wannergo;

import java.util.List;

public interface WannerDao {
    int insertwanner(Wannergo wannergo);
    List<Wannergo> selectWanner(int strategy_id);
    List<Wannergo> selectWannergo(int user_id);
}
