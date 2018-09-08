package org.lanqiao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/checkCode")
public class CheckCode extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");//页面加载出来后的code
        // 验证验证码
        String sessionCode = request.getSession().getAttribute("code").toString();//
        if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
            if (code.equalsIgnoreCase(sessionCode)) {
//                response.getWriter().println("验证通过！");
                PrintWriter out=response.getWriter();
                out.print(0);
                out.flush();
                out.close();

            } else {
//                response.getWriter().println("验证码输入错误");
                PrintWriter out=response.getWriter();
                out.print(1);
                out.flush();
                out.close();
            }
        } else {
//            response.getWriter().println("请输入验证码");
            System.out.println("yes");
            PrintWriter out=response.getWriter();
            out.print(2);
            out.flush();
            out.close();
        }
    }

}
