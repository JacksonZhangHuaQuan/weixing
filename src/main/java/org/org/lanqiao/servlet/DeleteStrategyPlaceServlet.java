package org.lanqiao.servlet;

import org.lanqiao.serviceImpl.StrategyPlaceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteStrategyPlace")
public class DeleteStrategyPlaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strategy_id=request.getParameter("strategy_id");
        int ret = new StrategyPlaceServiceImpl().deleteStrategyPlace(Integer.parseInt(strategy_id));
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
