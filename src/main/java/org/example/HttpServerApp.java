package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class HttpServerApp {
    public static void start() throws Exception {
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        RootHandler rootHandler = new RootHandler(usuarioService);


        InetSocketAddress socket = new InetSocketAddress(8080);
        HttpServer server = HttpServer.create(socket,0);

        server.createContext("/", rootHandler);
        server.start();

        System.out.println("server started on localhost:8080");
    }
}
