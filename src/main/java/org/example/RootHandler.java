package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class RootHandler implements HttpHandler {

    private final UsuarioService usuarioService;

    public RootHandler(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String response;
        int statusCode = 200;

        try{
            response = usuarioService.listUsuario();
        }catch (Exception e){
            e.printStackTrace();
            response = "Server error";
            statusCode = 500;
        }

        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=UTF-8");
        exchange.sendResponseHeaders(200,bytes.length);

        try(OutputStream os = exchange.getResponseBody()){
            os.write(bytes);
        }

    }
}
