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

@WebServlet("/ShowAddressServlet")
public class ShowAddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = request.getParameter("address");
        System.out.println("================" + address);
        StrategyDaoImpl dao = new StrategyDaoImpl();
        List<Strategy> list = dao.selectAreaStrategy(address);
        JSONArray listArray = JSONArray.fromObject(list);
        PrintWriter send = response.getWriter();
        send.print(listArray.toString());
        send.flush();
        send.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
