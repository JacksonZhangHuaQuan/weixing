package org.lanqiao.servlet;

import org.lanqiao.daoImpl.UserDaoImpl;
import org.lanqiao.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    UserDaoImpl userDao=new UserDaoImpl();
    UserServiceImpl userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username=request.getParameter("phone");
    String password=request.getParameter("password");
        Map<String,Object> userMap=userDao.userLogin(username,password);
//    int ret= userDao.userLogin(username,password);//
        String ret=(String) userMap.get("0");
        System.out.println(userMap.get("1"));


        if(ret=="2"){//登录成功，则返回sessionId
            System.out.println(ret);
            request.getSession().setAttribute("sessionkey",userMap.get("1"));//sessionkey
            System.out.println(request.getSession().getId());//得到sessionid
             response.getWriter().print(2);

        }
        else{//其他状态，则返回状态值ret
//            response.getWriter().print(false);
            System.out.println("进入");
            PrintWriter out=response.getWriter();
            out.print(ret);
            out.flush();
            out.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
