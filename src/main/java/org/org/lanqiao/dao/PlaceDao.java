package org.lanqiao.dao;


import org.lanqiao.entity.Place;

import java.util.List;

public interface PlaceDao {

    int insertPlace(Place place);

    int updatePlace(Place place);

    int deletePlace(int place_id);

    List<Place> selectPlace(int strategy_id);
}