// package com.example.demo.servlet;

// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import java.io.IOException;

// public class BasicServlet extends HttpServlet {

//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//         resp.setStatus(HttpServletResponse.SC_OK);
//         resp.getWriter().write("Servlet is running");
//     }

//     @Override
//     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//         resp.setStatus(HttpServletResponse.SC_CREATED);
//         resp.getWriter().write("Servlet POST handled");
//     }
// } 


package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BasicServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = resp.getWriter();
        writer.println("Servlet is running");
        writer.flush();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpServletResponse.SC_CREATED);
        PrintWriter writer = resp.getWriter();
        writer.println("Servlet POST handled");
        writer.flush();
    }
}


