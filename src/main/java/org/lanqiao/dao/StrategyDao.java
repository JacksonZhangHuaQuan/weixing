package org.lanqiao.dao;

import org.lanqiao.entity.Strategy;

import java.util.List;

public interface StrategyDao {

    //插入攻略
    int insertStrategy(Strategy strategy);

    //更改攻略
    int updateStrategy(Strategy strategy);

    //查询一个
    Strategy selectOneStrategy(String strategy_id);

    //条件模糊查询
    List<Strategy> selectLikeStrategy(String search);

    //查询全部
    List<Strategy> selectAllStrategy();
}
