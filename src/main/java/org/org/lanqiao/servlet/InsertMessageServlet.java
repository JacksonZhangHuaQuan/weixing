package org.lanqiao.servlet;

import org.lanqiao.daoImpl.GroupChatDaoImpl;
import org.lanqiao.entity.GroupChat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/InsertMessageServlet")
public class InsertMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strategy_id = request.getParameter("strategy_id");
        String user_id = request.getParameter("user_id");
        String messages = request.getParameter("messages");
        int group_id = Integer.parseInt(strategy_id);
        int id = Integer.parseInt(user_id);
        GroupChat groupChat = new GroupChat(group_id, id, messages);
        int ret = new GroupChatDaoImpl().insertMessage(groupChat);
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
