package org.lanqiao.dao;

import org.lanqiao.entity.Attraction;

import java.util.List;

public interface AttractionDao {

    //插入景点
    int insertAttraction(Attraction attraction);

    //更改景点
    int updateAttraction(Attraction attraction);

    //查询
    List<Attraction> selectAttraction(String strategy_id);

}
