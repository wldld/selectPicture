package com.yz.v1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "receiveServlet")
public class receiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");//跨域访问不安全，暂时写上去，方便静态页面访问
        StringBuffer jsonBuffer = new StringBuffer();
        String lineString = null;

            BufferedReader reader = request.getReader();
            while ((lineString = reader.readLine())!= null){
                jsonBuffer.append(lineString);
            }

        String jsonStr = jsonBuffer.toString();
        imgShow imgShow = new imgShow();
        try {
            imgShow.updataImg(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write(" ");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("helllo World!");
    }
}
