package com.it.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UserdServlet extends BaseServlet{

   public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
       System.out.println("UserdServlet.....selectAll...");
   };

   public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
       System.out.println("UserdServlet.....add...");
   }




}
