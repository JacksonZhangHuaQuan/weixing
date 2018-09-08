package org.lanqiao.servlet;

import org.lanqiao.daoImpl.StrategyDaoImpl;
import org.lanqiao.entity.Place;
import org.lanqiao.entity.Strategy;
import org.lanqiao.serviceImpl.StrategyPlaceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet( "/UpdateStrategyPlace")
public class UpdateStrategyPlaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("strategy_id");
        int strategy_id = Integer.parseInt(id);
        String strategy_title = request.getParameter("title");
        String firstImg = request.getParameter("first_img");
        String images = request.getParameter("images");
        //除去最后一个,判断是否为空 最后一位是否有,
        if(images !=null && images.indexOf("?") != -1){
            images = images.substring(0, images.lastIndexOf(','));
        }
        String date = request.getParameter("play_time");
        java.sql.Date strategy_date = null;
        if (date != null) {
            //date 转换
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                strategy_date = new java.sql.Date(formatter.parse(date).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        int strategy_days = Integer.parseInt(request.getParameter("play_day"));
        String strategy_address = request.getParameter("play_address");
        int strategy_money = Integer.parseInt(request.getParameter("play_price"));


        String strategy_describe = request.getParameter("play_description");

        Strategy strategy = new Strategy(strategy_id, strategy_title, firstImg,
                strategy_date, strategy_days, strategy_address, strategy_money,
                 strategy_describe, images);

        String[] placeNames = request.getParameterValues("placeName");
        String[] placeDescriptions = request.getParameterValues("placeDescription");
        String[] place_ids = request.getParameterValues("place_id");

        int ret = 0;//返回0 代表插入失败
        if (placeNames != null) {
            List<Place> placeList = new ArrayList<Place>();
            for (int i = 0; i < placeNames.length; i++) {
                Place place = new Place( placeNames[i], placeDescriptions[i],Integer.parseInt(place_ids[i]));
                placeList.add(place);
            }
            ret = new StrategyPlaceServiceImpl().updateStrategyPlace(strategy,placeList);
        } else {
            ret = new StrategyDaoImpl().updateStrategy(strategy);
        }

        //返回修改结果给客户端
        response.getWriter().print(ret);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
