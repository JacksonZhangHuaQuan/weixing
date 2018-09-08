package org.lanqiao.service;

import org.lanqiao.entity.Place;
import org.lanqiao.entity.Strategy;

import java.util.List;

public interface StrategyPlaceService {


    int insertStrategyPlace(Strategy strategy, List<Place> listPlace);

    int updateStrategyPlace(Strategy strategy, List<Place> listPlace);

    int deleteStrategyPlace(int strategy_id);



    List selectStrategyPlace(int strategy_id);

}
