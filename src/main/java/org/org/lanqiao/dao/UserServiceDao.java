package org.lanqiao.dao;

import org.lanqiao.daoImpl.BaseDaoImpl;
import org.lanqiao.entity.User;

import java.util.List;
import java.util.Map;

public interface UserServiceDao extends BaseDao<User>{
    public int checUser(List<User> list, String username, String password);
    public Map<String,Object> checkUser1(List<User> list, String phone, String password);
    public Map<String,Object> lockStatus(String phone, String password);
    public int unlockuser(String phone, String password);

    boolean checkPhone(String user_phone);
}
