package org.lanqiao.daoImpl;

import org.lanqiao.dao.StrategyDao;
import org.lanqiao.entity.Strategy;

import java.util.List;

public class StrategyDaoImpl extends BaseDaoImpl<Strategy> implements StrategyDao {
    @Override
    public int insertStrategy(Strategy strategy) {
        return 0;
    }

    @Override
    public int updateStrategy(Strategy strategy) {
        return 0;
    }

    //根据ID查询攻略
    @Override
    public List<Strategy> selectOneStrategy(int strategy_id) {
        String sql = "select * from strategy where strategy_id = ? and strategy_status='通过'";
        return executeQuery(sql, new Object[]{strategy_id});
    }

    @Override
    public List<Strategy> selectLikeStrategy(String search) {
        return null;
    }

    @Override
    //全部攻略
    public List<Strategy> selectAllStrategy() {
        return executeQuery("select * from strategy where  strategy_status='通过'");
    }

    //最热攻略
    @Override
    public List<Strategy> selectScoreStrategy(){
        return  executeQuery("select * from strategy where  strategy_status='通过' order by strategy_score desc limit 5");
    }

    //当季攻略
    @Override
    public List<Strategy> selectSeasonStrategy(String season){
        String sql = "select * from strategy where strategy_season=? and strategy_status='通过' order by strategy_score desc limit 6";
        return executeQuery(sql, new Object[]{season});
    }
    public List<Strategy> selectALLSeasonStrategy(String season){
        String sql = "select * from strategy where strategy_season=? and strategy_status='通过' order by strategy_score desc ";
        return executeQuery(sql, new Object[]{season});
    }
    public List<Strategy> selectBestSeasonStrategy(){
        String sql = "select * from strategy where strategy_season='夏季' and strategy_status='通过' order by strategy_score desc ";
        return executeQuery(sql);
    }

    //短假出行
    public List<Strategy> selectShortStrategy(){
        String sql = "select * from strategy where strategy_days<=3 and strategy_status='通过' order by strategy_score desc limit 6";
        return executeQuery(sql);
    }
    public List<Strategy> selectAllShortStrategy(){
        String sql="select * from strategy where strategy_days<=3 and strategy_status='通过' order by strategy_score desc";
        return executeQuery(sql);
    }

    @Override
    public List<Strategy> selectAreaStrategy(String address) {
        String sql = "select * from strategy where strategy_address=? and strategy_status='通过' order by strategy_score desc limit 6";
        return executeQuery(sql, new Object[]{address});
    }

    @Override
    public List<Strategy> selectPoorStrategy() {
        String sql = "select * from strategy where strategy_money <=500 and strategy_status='通过' order by strategy_score desc limit 6";
        return executeQuery(sql);
    }
    public List<Strategy> selectAllPoorStrategy() {
        String sql = "select * from strategy where strategy_money <=500 and strategy_status='通过' order by strategy_score desc";
        return executeQuery(sql);
    }

    @Override
    public List<Strategy> selectDayStrategy(int day) {
        String sql = "select * from strategy where strategy_days = ? and strategy_status='通过' order by strategy_score desc limit 6";
        return executeQuery(sql, new Object[]{day});
    }


//    ================================================
@Override
public int getNextID() {
    String sql=  "select auto_increment from information_schema.`TABLES` where table_name='strategy' and TABLE_SCHEMA='weixing'";
    return executeQueryCount(sql)-1;
}

    @Override
    public List<Strategy> queryUserStrategy(int user_id) {
        String sql = "SELECT strategy_id,strategy_title,strategy_firstimg,strategy_season,strategy_days,strategy_type,strategy_address,strategy_status FROM strategy where user_id =? order by strategy_status";
        return executeQuery(sql,new Object[]{user_id});
    }
    public List<Strategy> selectDaysStrategy(int days){
        String sql="select * from strategy where strategy_days =? and strategy_status='通过'";
        return executeQuery(sql,new Object[]{days});
    }
}
