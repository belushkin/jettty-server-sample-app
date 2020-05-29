package com.myjetty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("MyServlet.init()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("I am inside service");
    }

    @Override
    public void destroy() {
        System.out.println("MyServlet.destroy()");
    }
}
