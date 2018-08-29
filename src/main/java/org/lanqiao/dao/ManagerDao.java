package org.lanqiao.dao;

import org.lanqiao.entity.Manager;
import org.lanqiao.entity.Strategy;

import java.util.List;

public interface ManagerDao {

    //添加管理员
    int insertManager(Manager manager);

    //删除管理员
    int deteleManager(String manager_id);

    //查看全部攻略
    List<Strategy> lookAllStrategy();

    //查看待审核攻略
    List<Strategy> lookWaitStrategy(String info);

    //一条攻略
    Strategy lookOneStrategy(String strategy_id);

    //审核通过
    int updateStrategy(String pass);
}
