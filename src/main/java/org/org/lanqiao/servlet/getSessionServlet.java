package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.lanqiao.entity.User;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/getSession")
public class getSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String key=request.getParameter("sessionid");
//        System.out.println(request.getSession().getId());
        System.out.println("getsession");
//        System.out.println(request.getSession().getAttribute(key));
        List<User> list=(List<User>) request.getSession().getAttribute(key);
//        System.out.println(list.get(0).getUser_phone());
//        System.out.println(list.get(0).getUser_passw());

        PrintWriter out=response.getWriter();
        if(!("").equals(key)){
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
            JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);//user为我的对象
            System.out.println(jsonArray);
            out.print(jsonArray);
            out.flush();
            out.close();
        }else{
            out.write("nologin");
            out.flush();
            out.close();

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
