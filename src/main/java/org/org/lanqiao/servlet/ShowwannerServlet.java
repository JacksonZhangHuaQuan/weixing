package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.daoImpl.WannergoDaoImpl;
import org.lanqiao.entity.Wannergo;
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

@WebServlet("/ShowwannerServlet")
public class ShowwannerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String Strategy_id1=request.getParameter("user_id");
        int user_id=Integer.parseInt(Strategy_id1);
        WannergoDaoImpl comm=new WannergoDaoImpl ();
        List<Wannergo> list=comm.selectWannergo(user_id);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray listArray = JSONArray.fromObject(list,jsonConfig);
        System.out.println(listArray);
        PrintWriter out=response.getWriter();
        out.print(listArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
