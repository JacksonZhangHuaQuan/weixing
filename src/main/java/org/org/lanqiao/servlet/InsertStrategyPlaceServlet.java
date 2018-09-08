package org.lanqiao.servlet;

import org.lanqiao.daoImpl.StrategyDaoImpl;
import org.lanqiao.entity.Place;
import org.lanqiao.entity.Strategy;
import org.lanqiao.entity.Strategy_Bruce;
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

@WebServlet("/Strategy")
public class InsertStrategyPlaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("user_id");
        int user_id = Integer.parseInt(id);
        String strategy_title = request.getParameter("title");
        String firstImg = request.getParameter("first_img");
        String images = request.getParameter("images");
        //除去最后一个,
        if(images != null && images != ""){
            images = images.substring(0, images.lastIndexOf(','));
        }
        String date = request.getParameter("play_time");
        //date 转换
        java.util.Date strategy_date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            strategy_date = new java.util.Date(formatter.parse(date).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int strategy_days = Integer.parseInt(request.getParameter("play_day"));
        String strategy_address = request.getParameter("play_address");
        int strategy_money = Integer.parseInt(request.getParameter("play_price"));
        String[] type = request.getParameterValues("play_type");
        String strategy_type = "";
        for (int i = 0; i < type.length; i++) {
            if (i < type.length - 1) {
                strategy_type = strategy_type + type[i].concat(",");
            } else {
                strategy_type = strategy_type + type[i];
            }
        }
        String strategy_season = request.getParameter("play_season");
        String strategy_describe = request.getParameter("play_description");
        int strategy_score = Integer.parseInt(request.getParameter("play_star"));
        Strategy strategy = new Strategy(user_id, strategy_title, firstImg,
                strategy_date, strategy_days, strategy_address, strategy_money,
                strategy_type, strategy_season, strategy_describe, images, strategy_score);

        String[] placeNames = request.getParameterValues("placeName");
        String[] placeDescriptions = request.getParameterValues("placeDescription");

        //如果用户添加了详细描述，向两个表插入否则只向一个表插入
        int ret = 0;//返回0 代表插入失败
        if (placeNames != null) {
            List<Place> placeList = new ArrayList<Place>();
            for (int i = 0; i < placeNames.length; i++) {
                Place place = new Place(1, placeNames[i], placeDescriptions[i]);
                placeList.add(place);
            }
            ret = new StrategyPlaceServiceImpl().insertStrategyPlace(strategy, placeList);
        } else {
            ret = new StrategyDaoImpl().insertStrategy(strategy);
        }

        //返回插入结果给客户端
        response.getWriter().print(ret);

    }


}
