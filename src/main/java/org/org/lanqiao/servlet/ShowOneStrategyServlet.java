package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.CommentDao;
import org.lanqiao.dao.PlaceDao;
import org.lanqiao.dao.StrategyDao;
import org.lanqiao.daoImpl.CommentDaoImpl;
import org.lanqiao.daoImpl.PlaceDaoImpl;
import org.lanqiao.daoImpl.StrategyDaoImpl;
import org.lanqiao.entity.Comment;
import org.lanqiao.entity.Place;
import org.lanqiao.entity.Strategy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowOneStrategyServlet")
public class ShowOneStrategyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String s_id = request.getParameter("strategy_id");
        int strategy_id = Integer.parseInt(s_id);

        //获取攻略
        StrategyDao strategyDao = new StrategyDaoImpl();
        List<Strategy> listStrategy = strategyDao.selectOneStrategy(strategy_id);
        System.out.println("strategy:" + listStrategy);

        //获取景点
        PlaceDao placeDao = new PlaceDaoImpl();
        List<Place> placeList = placeDao.selectPlace(strategy_id);
        System.out.println("place:" + placeList);

        //获取评论
        CommentDao commentDao = new CommentDaoImpl();
        List<Comment> commentList = commentDao.selectComment(strategy_id);
        System.out.println("comment" + commentList);

        List list = new ArrayList();
        list.add(listStrategy);
        list.add(placeList);
        list.add(commentList);

        response.setCharacterEncoding("utf-8");
        System.out.println(list);
        JSONArray listArray = JSONArray.fromObject(list);
        System.out.println(listArray);
        PrintWriter send = response.getWriter();
        send.print(listArray);
        send.flush();
        send.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
