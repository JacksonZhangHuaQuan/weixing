package org.lanqiao.serviceImpl;

import org.lanqiao.dao.CommentDao;
import org.lanqiao.dao.PlaceDao;
import org.lanqiao.dao.StrategyDao;
import org.lanqiao.daoImpl.BaseDaoImpl;
import org.lanqiao.daoImpl.CommentDaoImpl;
import org.lanqiao.daoImpl.PlaceDaoImpl;
import org.lanqiao.daoImpl.StrategyDaoImpl;
import org.lanqiao.entity.Comment;
import org.lanqiao.entity.Place;
import org.lanqiao.entity.Strategy;
import org.lanqiao.service.StrategyPlaceService;

//import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class StrategyPlaceServiceImpl implements StrategyPlaceService{



    //插入攻略和景点
    @Override
    public int insertStrategyPlace(Strategy strategy, List<Place> placeList) {
        Connection conn = null;
        int ret = 0;
        try {
            conn = BaseDaoImpl.getConnection();
            conn.setAutoCommit(false);

            java.sql.Date strategy_date = new java.sql.Date(strategy.getStrategy_date().getTime());

            String sql1 = "insert into strategy(user_id,strategy_title,strategy_firstimg," +
                    "strategy_date,strategy_days,strategy_address,strategy_money," +
                    "strategy_type,strategy_season,strategy_describe,strategy_photos,strategy_score)" +
                    "                  values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, strategy.getUser_id());
            ps1.setString(2, strategy.getStrategy_title());
            ps1.setString(3, strategy.getStrategy_firstimg());
            ps1.setDate(4, strategy_date);
            ps1.setInt(5, strategy.getStrategy_days());
            ps1.setString(6, strategy.getStrategy_address());
            ps1.setInt(7, strategy.getStrategy_money());
            ps1.setString(8, strategy.getStrategy_type());
            ps1.setString(9, strategy.getStrategy_season());
            ps1.setString(10, strategy.getStrategy_describe());
            ps1.setString(11, strategy.getStrategy_photos());
            ps1.setInt(12, strategy.getStrategy_score());

            ret = ps1.executeUpdate();

            //查询下一个id值

            //插入地点信息
            for (int i = 0; i < placeList.size(); i++) {
                String sql2 = "INSERT INTO place (strategy_id,place_name,place_description) values (?,?,?)";
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setInt(1, new StrategyDaoImpl().getNextID());
                ps2.setString(2, placeList.get(i).getPlace_name());
                ps2.setString(3, placeList.get(i).getPlace_description());
                ps2.executeUpdate();
            }
            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    //更新攻略和景点
    @Override
    public int updateStrategyPlace(Strategy strategy, List<Place> placeList) {
        Connection conn = null;
        int ret = 0;
        try {
            conn = BaseDaoImpl.getConnection();
            conn.setAutoCommit(false);
            java.sql.Date strategy_date = new java.sql.Date(strategy.getStrategy_date().getTime());
            //修改攻略表
            String sql1 = "update strategy set strategy_title = ? ,strategy_firstimg = ?,strategy_date= ?," +
                    "strategy_days= ?,strategy_address =?,strategy_money = ?, " +
                    "strategy_describe=?,strategy_photos=?,strategy_score= ?" +
                    " where strategy_id = ? ";

            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, strategy.getStrategy_title());
            ps1.setString(2, strategy.getStrategy_firstimg());
            ps1.setDate(3, strategy_date);
            ps1.setInt(4, strategy.getStrategy_days());
            ps1.setString(5, strategy.getStrategy_address());
            ps1.setInt(6, strategy.getStrategy_money());
            ps1.setString(7, strategy.getStrategy_describe());
            ps1.setString(8, strategy.getStrategy_photos());
            ps1.setInt(9, strategy.getStrategy_score());
            ps1.setInt(10,strategy.getStrategy_id());
//            ps1.setInt(10,13);

            ret = ps1.executeUpdate();
            System.out.println("修改影响条数！");

            //修改地点信息
            if (placeList.size()!=0){
                for (int i = 0; i < placeList.size(); i++) {
                    String sql2 = "update place set place_name = ?, place_description = ? where place_id = ?";
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setString(1, placeList.get(i).getPlace_name());
                    ps2.setString(2, placeList.get(i).getPlace_description());
                    ps2.setInt(3, placeList.get(i).getPlace_id());
                    ps2.executeUpdate();
                }
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    //删除攻略和景点
    @Override
    public int deleteStrategyPlace(int strategy_id) {

        Connection conn = null;

        try {
            conn = BaseDaoImpl.getConnection();
            conn.setAutoCommit(false);
            String sql1 = "DELETE FROM place WHERE strategy_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql1);
            ps2.setInt(1, strategy_id);
            ps2.executeUpdate();

            //删除攻略信息
            String sql2 = "delete from strategy where strategy_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql2);
            ps1.setInt(1, strategy_id);
            ps1.executeUpdate();
            conn.commit();
            return 1;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }


    //获取数据
    @Override
    public List selectStrategyPlace(int strategy_id) {


        //获取攻略
        StrategyDao strategyDao = new StrategyDaoImpl();
        Strategy strategy = new Strategy();
        List<Strategy> listStrategy = strategyDao.selectOneStrategy(strategy_id);
        if(listStrategy!=null && listStrategy.size()>0){
            strategy = listStrategy.get(0);
        }

        //获取景点
        PlaceDao placeDao = new PlaceDaoImpl();
        List<Place> placeList = placeDao.selectPlace(strategy_id);

        //获取评论
        CommentDao commentDao = new CommentDaoImpl();
        List<Comment> commentList = commentDao.selectComment(strategy_id);


        return null;
    }


}
