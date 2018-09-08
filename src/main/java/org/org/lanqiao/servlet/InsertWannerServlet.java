package org.lanqiao.servlet;

import org.lanqiao.daoImpl.WannergoDaoImpl;
import org.lanqiao.entity.Wannergo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/InsertWannerServlet")
public class InsertWannerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id1=request.getParameter("user_id");
        int user_id=Integer.parseInt(user_id1);
        System.out.println(user_id);
        String strategy_id1=request.getParameter("strategy_id");
        int strategy_id=Integer.parseInt(strategy_id1);
        System.out.println(strategy_id);
        Wannergo wanner=new Wannergo(user_id,strategy_id);
        WannergoDaoImpl wannergoDao=new WannergoDaoImpl();
        int ret= wannergoDao.insertwanner(wanner);
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
