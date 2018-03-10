package com.yz.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");//跨域访问不安全，暂时写上去，方便静态页面访问
        imgShow imgs= new imgShow();
        int pageNum = 1; //未完全写好，暂时使用的
        PrintWriter writer = null;
        try {
            String jsonStr = imgs.showImg(pageNum);
            writer = response.getWriter();
            writer.append(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
