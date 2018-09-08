package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.StrategyDao;
import org.lanqiao.daoImpl.SelectOneStrategy;
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

@WebServlet("/SelectOneStrategyServlet")
public class SelectOneStrategyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strategy_id1=request.getParameter("strategy_id");
        int strategy_id=Integer.parseInt(strategy_id1);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        response.setCharacterEncoding("utf-8");
        SelectOneStrategy selectOneStrategy=new SelectOneStrategy();
        List<Strategy> listStrategy = selectOneStrategy.selectOneStrategy(strategy_id);
        JSONArray listArray = JSONArray.fromObject(listStrategy,jsonConfig);
        PrintWriter out=response.getWriter();
        out.print(listArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
