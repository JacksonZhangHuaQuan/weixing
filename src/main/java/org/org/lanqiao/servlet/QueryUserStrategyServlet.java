package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.daoImpl.StrategyDaoImpl;
import org.lanqiao.entity.Strategy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/QueryUserStrategy")
public class QueryUserStrategyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("user_id");
        int user_id = Integer.parseInt(id);
        List<Strategy> strategiesList = new StrategyDaoImpl().queryUserStrategy(user_id);
        response.setCharacterEncoding("utf-8");
        JSONArray listArray = JSONArray.fromObject(strategiesList);
        PrintWriter out = response.getWriter();
        out.print(listArray);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
