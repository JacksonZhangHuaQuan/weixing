package org.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.util.UploadPic;

import net.sf.json.JSONObject;

/**
 * Created by David on 17/8/23.
 */
@WebServlet("/uploadPic")
public class UploadPicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String img = request.getParameter("img");
        String imgName = UploadPic.upload(img,request.getServletContext().getRealPath("/") + "upload/");
        JSONObject jsonObj = new  JSONObject();
        jsonObj.accumulate("imgUrl", "/upload/"+imgName);
        response.getWriter().print(jsonObj.toString());
    }

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
