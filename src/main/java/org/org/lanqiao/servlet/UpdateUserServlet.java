package org.lanqiao.servlet;

import net.sf.json.JsonConfig;
import org.lanqiao.daoImpl.UserDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.util.JsonDateValueProcessor;
import org.lanqiao.util.JsonDateValueProcessor1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet( "/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        UserDaoImpl userDao=new UserDaoImpl();
        User user=new User();
        String gender=request.getParameter("gender");
        String birthday=request.getParameter("birthday");
        String name=request.getParameter("name");
        String petname=request.getParameter("petname");
        String introduce=request.getParameter("introduce");
        String id=request.getParameter("userid");
        String imgurl=request.getParameter("imgurl");
        int userid=Integer.parseInt(id);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
           Date birthday1= df.parse(birthday);
            user.setUser_birthday(birthday1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor1());
        user.setUser_gender(gender);
        user.setUser_pet_name(petname);
        user.setUser_introduce(introduce);
        user.setUser_id(userid);
        user.setUser_name(name);
        user.setUser_photo(imgurl);
        int ret=userDao.userUpdate(user);
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
