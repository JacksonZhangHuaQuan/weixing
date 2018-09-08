package org.lanqiao.servlet;

import org.lanqiao.daoImpl.UserDaoImpl;
import org.lanqiao.serviceImpl.UserServiceImpl;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addNewUser")
public class regServlet extends HttpServlet {
    UserDaoImpl userDao=new UserDaoImpl();
    UserServiceImpl userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取表单数据
        String phone=request.getParameter("phone");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
       //检查手机号是否存在

        boolean ret1=userService.checkPhone(phone);
        System.out.println(ret1);
//        System.out.println();
        if (ret1==false){//存在
            PrintWriter out = response.getWriter();
            out.print(-1);//返回给ajax
            out.flush();
            out.close();
        } else{//不存在
            User user=new User();
            user.setUser_name(username);
            user.setUser_phone(phone);
            user.setUser_passw(password);
            System.out.println(user.getUser_name());
            System.out.println(user.getUser_phone());
            System.out.println(user.getUser_passw());
            int ret = userDao.userRegister(user);
            System.out.println("影响条数" + ret);
            PrintWriter out = response.getWriter();
            out.print(9);//返回给ajax
            out.flush();
            out.close();

        }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doPost(request,response);
    }
}
