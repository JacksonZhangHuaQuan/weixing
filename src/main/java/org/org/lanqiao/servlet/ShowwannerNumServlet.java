package org.lanqiao.servlet;

import com.sun.prism.shader.Solid_Color_AlphaTest_Loader;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.daoImpl.CommentDaoImpl;
import org.lanqiao.daoImpl.WannergoDaoImpl;
import org.lanqiao.entity.Wannergo;
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

@WebServlet("/ShowwannerNumServlet")
public class ShowwannerNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Strategy_id1=request.getParameter("strategy_id");
        int strategy_id=Integer.parseInt(Strategy_id1);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        WannergoDaoImpl comm=new WannergoDaoImpl ();
        List<Wannergo> list=comm.selectWanner(strategy_id);
        System.out.println(list);
        JSONArray listArray = JSONArray.fromObject(list,jsonConfig);
        System.out.println(listArray);
        PrintWriter out=response.getWriter();
        out.print(listArray);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
