package org.lanqiao.dao;


import org.lanqiao.entity.Strategy;
import org.lanqiao.entity.User;

import java.util.List;
import java.util.Map;


public interface UserDao {

    //检查手机号
//    boolean checkPhone(String user_phone);
    //注册
    int userRegister(User user);

    //登录
    Map<String,Object> userLogin(String user_name, String password);

    //更改
    int userUpdate(User user);

    //查询
    List<User> userSelect(int id);

    //查看全部攻略
    List<Strategy> lookAllStrategy();

    //条件查看攻略
    List<Strategy> lookLikeStrategy(String search);


    //一条攻略
    Strategy lookOneStrategy(String strategy_id);

    //修改攻略
    int updateStrategy(Strategy strategy);

//显示部分用户信息
    List<User> UserShow(User user);

}
