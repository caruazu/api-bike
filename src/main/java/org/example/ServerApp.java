package org.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.net.URI;

public class ServerApp {

    private static final String BASE_URL = "http://localhost:8080/";
    private HttpServer server;

    public void start() throws Exception {
        URI baseUri = URI.create(BASE_URL);
        AppConfig appConfig = new AppConfig();

        server = GrizzlyHttpServerFactory.createHttpServer(baseUri,appConfig);

        System.out.println("server started on localhost:8080");
    }

    public void stop() {
        if (server != null) {
            server.shutdownNow();
        }
    }
}
