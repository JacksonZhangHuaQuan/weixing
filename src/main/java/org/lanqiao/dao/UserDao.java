package org.lanqiao.dao;


import org.lanqiao.entity.Strategy;
import org.lanqiao.entity.User;

import java.util.List;


public interface UserDao {

    //注册
    int userRegister(User user);

    //登录
    int userLogin(String id, String password);

    //更改
    int userUpdate(User user);

    //查询
    User userSelect(String id);

    //查看全部攻略
    List<Strategy> lookAllStrategy();

    //条件查看攻略
    List<Strategy> lookLikeStrategy(String search);


    //一条攻略
    Strategy lookOneStrategy(String strategy_id);

    //修改攻略
    int updateStrategy(Strategy strategy);

}
