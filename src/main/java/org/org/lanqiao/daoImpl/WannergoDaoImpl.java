package org.lanqiao.daoImpl;

import org.lanqiao.dao.WannerDao;
import org.lanqiao.entity.Wannergo;

import java.util.List;

public class WannergoDaoImpl extends BaseDaoImpl<Wannergo> implements WannerDao {
    @Override
    public int insertwanner(Wannergo wannergo) {
        return executeUpdate("insert into wannergo(user_id,strategy_id1) values(?,?)",new Object[]{wannergo.user_id,wannergo.strategy_id1});
    }

    @Override
    public List<Wannergo> selectWanner(int strategy_id) {
        return executeQuery("select * from wannergo where strategy_id1=?",new Object[]{strategy_id});
    }

    @Override
    public List<Wannergo> selectWannergo(int user_id) {
        return executeQuery("select * from wannergo where user_id=?",new Object[]{user_id});
    }

}
