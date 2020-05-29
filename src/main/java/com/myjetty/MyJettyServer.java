package com.myjetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class MyJettyServer {

    private Server server;

    public void start() throws Exception {
        server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8090);
        server.setConnectors(new Connector[]{connector});

        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);

        servletHandler.addServletWithMapping(MyServlet.class, "/status");
        servletHandler.addServletWithMapping(MyServlet2.class, "/status2");
        servletHandler.addServletWithMapping(MyFreemarkerServlet.class, "/freemarker");

        server.start();
    }

    public void stop() throws Exception{
        server.stop();
    }

}
