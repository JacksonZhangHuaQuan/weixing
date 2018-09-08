package org.lanqiao.daoImpl;

import org.lanqiao.dao.PlaceDao;
import org.lanqiao.entity.Place;

import java.util.List;


public class PlaceDaoImpl extends BaseDaoImpl<Place> implements PlaceDao {

    //插入景点
    @Override
    public int insertPlace(Place place) {
        String sql = "insert into place values(?, ?, ?, ?)";
        executeUpdate(sql, new Object[]{place.getPlace_id(), place.getStrategy_id(), place.getPlace_name(), place.getPlace_description()});
        return 0;
    }

    //更新景点
    @Override
    public int updatePlace(Place place) {
        String sql = "update place set place_name = ?, place_description = ? where place_id = ?";
        executeUpdate(sql, new Object[]{place.getPlace_name(), place.getPlace_description(), place.getPlace_id()});
        return 0;
    }

    //删除景点
    @Override
    public int deletePlace(int place_id) {
        String sql = "delete from place where place_id = ?";
        executeUpdate(sql , new Object[]{place_id});
        return 0;
    }

    //根据攻略ID，查看景点
    @Override
    public List<Place> selectPlace(int strategy_id) {
        String sql = "select * from place where strategy_id = ?";
        return executeQuery(sql, new Object[]{strategy_id});
    }
}
