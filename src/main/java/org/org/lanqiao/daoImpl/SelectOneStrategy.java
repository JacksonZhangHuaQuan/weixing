package org.lanqiao.daoImpl;

import org.lanqiao.dao.StrategyDao;
import org.lanqiao.entity.Strategy;

import java.util.List;

public class SelectOneStrategy extends BaseDaoImpl<Strategy> {
    public List<Strategy> selectOneStrategy(int strategy_id) {
        return executeQuery("select * from strategy where strategy_id=?",new Object[]{strategy_id});
    }
}
