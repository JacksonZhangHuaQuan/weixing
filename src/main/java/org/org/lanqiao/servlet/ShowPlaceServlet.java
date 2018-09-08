package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.PlaceDao;
import org.lanqiao.daoImpl.PlaceDaoImpl;
import org.lanqiao.entity.Place;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ShowPlaceServlet")
public class ShowPlaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_id = request.getParameter("strategy_id");
        int strategy_id = Integer.parseInt(s_id);
        response.setCharacterEncoding("utf-8");
        PlaceDao placeDao = new PlaceDaoImpl();
        List<Place> placeList = placeDao.selectPlace(strategy_id);
        JSONArray listArray = JSONArray.fromObject(placeList);
        PrintWriter out=response.getWriter();
        out.print(listArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
