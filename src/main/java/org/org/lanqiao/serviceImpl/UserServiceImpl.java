package org.lanqiao.serviceImpl;

import org.lanqiao.dao.UserServiceDao;
import org.lanqiao.daoImpl.BaseDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.util.MD5Util;

import java.util.*;

public class UserServiceImpl extends BaseDaoImpl<User> implements UserServiceDao {
    @Override
    public int checUser(List<User> list,String phone,String password) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getUser_passw().equals(password)&&list.get(i).getUser_phone().equals(phone))
            {
                return 1;
            }
        }
        return 0;

    }

    @Override
    public Map<String,Object> lockStatus(String phone, String password) {
        //查询用户锁定时间
        Map<String,Object> retMap=new HashMap<>();
        List<User> list=executeQuery("select * from user where user_phone=?",new  Object[]{phone});
        if(list.get(0).getUser_locktime()!=null)
        {//不等于null，则需解锁
            retMap.put("0","0");//0表示账户锁定
            retMap.put("1",list.get(0).getUser_locktime());
            return retMap;
        } else{
       //为null，则说用户正常
            retMap.put("0","1");//1表示账户正常
            retMap.put("1",null);
            return retMap;

        }

    }
    @Override
    public int unlockuser(String phone, String password) {

        return executeUpdate("UPDATE user set user_locktime=null where user_phone=?",new Object[]{phone});

    }


    @Override
    public Map<String,Object> checkUser1(List<User> list, String phone, String password) {
        int status=0;

        MD5Util md5Util=new MD5Util();
        String str=md5Util.crypt(password);


        Map<String,Object> userHashMap=new HashMap<>();
        List <User>userList=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getUser_passw().equals(str)&&list.get(i).getUser_phone().equals(phone))
            {userList=executeQuery("select * from user where user_phone=?",new Object[]{phone});
                //若果数据库中有该用户：手机号是唯一标识
                status=1;
                break;
            }
        }
        if(status==0){
           userHashMap.put("0","1");
            userHashMap.put("1",null);//用户不存在或密码输入错误
            return userHashMap;
        } else {//用户存在
            //判断用户状态
        Map<String,Object> ret=lockStatus(phone,password);
        String a=(String) ret.get("0");
        if (a=="0"){//0表示锁定
            Date date=(Date)ret.get("1");
            Date date1=new Date();
            long l=date1.getTime()-date.getTime();
            if(l/24*1000*60*60>=1){
                //解锁
                int unlockuser=unlockuser(phone,password);
                if(unlockuser==1){
                    userHashMap.put("0","2");
                    userHashMap.put("1",userList);
                    return userHashMap;//用户状态正常
                }else{
                    userHashMap.put("0","-1");
                    userHashMap.put("1",null);
                    return userHashMap;//服务器正忙，解锁未成功
                }

            }
            else {
                //还没有到解锁时间
                userHashMap.put("0","3");
                userHashMap.put("1",null);
                return userHashMap;//用户锁定
            }

            }else{
            userHashMap.put("0","2");
            userHashMap.put("1",userList);
            return userHashMap;//用户状态正常
        }

            //解锁操作
        }

        }






    @Override
    public boolean checkPhone(String user_phone) {
        List<User> list=executeQuery("select user_phone from user");
        for (int i=0;i<list.size();i++){
            if (user_phone.equals(list.get(i).getUser_phone())){
                return false;//如果存在手机号，则返回0
            }

        }
        return true;//否则不存在，返回1
    }
}
