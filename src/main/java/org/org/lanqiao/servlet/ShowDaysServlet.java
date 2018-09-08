package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.StrategyDao;
import org.lanqiao.daoImpl.StrategyDaoImpl;
import org.lanqiao.entity.Strategy;
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

@WebServlet("/ShowDaysServlet")
public class ShowDaysServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String day= request.getParameter("days");
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        int days = Integer.parseInt(day);
        response.setCharacterEncoding("utf-8");
        StrategyDao strategyDao = new StrategyDaoImpl();
        List<Strategy> listStrategy = ((StrategyDaoImpl) strategyDao).selectDaysStrategy(days);
        JSONArray listArray = JSONArray.fromObject(listStrategy,jsonConfig);
        PrintWriter out=response.getWriter();
        out.print(listArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
