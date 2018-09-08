package org.lanqiao.servlet;

import org.lanqiao.daoImpl.CommentDaoImpl;
import org.lanqiao.entity.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/InsertCommentServlet")
public class InsertCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment_content=request.getParameter("comment_content");
        String comment_num1=request.getParameter("comment_num");
        String strategy_id1=request.getParameter("strategy_id");
        String user_id1=request.getParameter("user_id");
        String user_name=request.getParameter("user_name");
        int comment_num=Integer.parseInt(comment_num1);
        int strategy_id=Integer.parseInt(strategy_id1);
        int user_id=Integer.parseInt(user_id1);
        Comment comment=new Comment(strategy_id,comment_content,comment_num,user_id,user_name);
        System.out.println();
        CommentDaoImpl comm=new CommentDaoImpl();
        int ret=comm.insertComment(comment);
        System.out.println(ret);
        //输出操作
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
