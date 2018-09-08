package org.lanqiao.daoImpl;

import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.Strategy;
import org.lanqiao.entity.User;
import org.lanqiao.serviceImpl.UserServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public int userRegister(User user) {
        return executeUpdate("INSERT INTO user (user_name,user_passw,user_phone) VALUES(?,MD5(?),?)", new Object[]{user.getUser_name(), user.getUser_passw(), user.getUser_phone()});
    }


    @Override
    public Map<String, Object> userLogin(String phone, String password) {
        Map<String, Object> userMap = new HashMap<>();
        List<User> list = executeQuery("select user_phone,user_passw from user");
        System.out.println(list);
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, Object> checkUserMap = new HashMap<>();
        checkUserMap = userService.checkUser1(list, phone, password);
        if (checkUserMap.get("0") == "1") {
            //用户不存在
            userMap.put("0", "1");
            userMap.put("1", checkUserMap.get("1"));
            return userMap;
        } else if (checkUserMap.get("0") == "2") {
            //用户状态正常
            userMap.put("0", "2");
            userMap.put("1", checkUserMap.get("1"));
            return userMap;
        } else if (checkUserMap.get("0") == "3") {
            //用户锁定
            userMap.put("0", "3");
            userMap.put("1", checkUserMap.get("1"));
            return userMap;
        } else {
            //服务器正忙
            userMap.put("0", "-1");
            userMap.put("1", checkUserMap.get("1"));
            return userMap;
        }


    }

    @Override
    public int userUpdate(User user) {
        String sql="update user set  user_name=?,user_gender=?,user_birthday=?,user_pet_name=?,user_introduce=?,user_photo=? where user_id=?";
        return executeUpdate(sql,new Object[]{user.getUser_name(),user.getUser_gender(),user.getUser_birthday(),user.getUser_pet_name(),user.getUser_introduce(),user.getUser_photo(),user.getUser_id()});
    }

    @Override
    public List<User> userSelect(int id) {
        String sql="select * from user where user_id=?";
        return executeQuery(sql,new Object[]{id});

    }

//    @Override
//    public User userSelect(int id) {
//        return null;
//    }

    @Override
    public List<Strategy> lookAllStrategy() {
        return null;
    }

    @Override
    public List<Strategy> lookLikeStrategy(String search) {
        return null;
    }

    @Override
    public Strategy lookOneStrategy(String strategy_id) {
        return null;
    }

    @Override
    public int updateStrategy(Strategy strategy) {
        return 0;
    }

    @Override
    public List<User> UserShow(User user) {
//        return executeQuery("SELECT user_gender,user_name,user_pet_name,user_role,user_birthday,user_phone,user_introduce FROM USER WHERE user_id="?,);
        return null;
    }
}
