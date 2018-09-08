package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.daoImpl.GroupChatDaoImpl;
import org.lanqiao.entity.GroupChat;
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

@WebServlet("/ShowMessageServlet")
public class ShowMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String group_id = request.getParameter("strategy_id");
        int groupid = Integer.parseInt(group_id);
        System.out.println("=========================" + group_id);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        List<GroupChat> list = new GroupChatDaoImpl().selectMessage(groupid);
        response.setCharacterEncoding("utf-8");
        JSONArray listArray = JSONArray.fromObject(list,jsonConfig);
        System.out.println(listArray);
        PrintWriter out = response.getWriter();
        out.print(listArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
