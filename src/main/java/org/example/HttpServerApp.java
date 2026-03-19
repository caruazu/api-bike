package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class HttpServerApp {
    public static void start() throws Exception {
        InetSocketAddress socket = new InetSocketAddress(8080);
        HttpServer server = HttpServer.create(socket,0);

        server.createContext("/", new RootHandler());
        server.start();

        System.out.println("server started on localhost:8080");
    }

    static class RootHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange){
            try {
                String response = "API-BIKE";
                byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

                exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=UTF-8");
                exchange.sendResponseHeaders(200,bytes.length);

                OutputStream os = exchange.getResponseBody();

                os.write(bytes);
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                exchange.close();
            }
        }
    }
}
