package org.lanqiao.dao;

import org.lanqiao.entity.Strategy;

import java.util.List;

public interface StrategyDao {

    //插入攻略
    int insertStrategy(Strategy strategy);

    //更改攻略
    int updateStrategy(Strategy strategy);

    //查询一个
    List<Strategy> selectOneStrategy(int strategy_id);

    //条件模糊查询
    List<Strategy> selectLikeStrategy(String search);

    //查询全部
    List<Strategy> selectAllStrategy();

    //最热攻略
    List<Strategy> selectScoreStrategy();

    //当季攻略
    List<Strategy> selectSeasonStrategy(String season);

    //短假出行
    List<Strategy> selectShortStrategy();

    //地点查询
    List<Strategy> selectAreaStrategy(String address);

    //穷游出行
    List<Strategy> selectPoorStrategy();

    //天数查询
    List<Strategy> selectDayStrategy(int day);

    //    =======================================================
//获取下一个攻略id
    int getNextID();

    //查询一个用户发布的所有攻略
    List<Strategy> queryUserStrategy(int user_id);
}
