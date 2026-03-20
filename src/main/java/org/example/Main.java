package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        ServerApp serverApp = new ServerApp();

        serverApp.start();
        Runtime.getRuntime().addShutdownHook(new Thread(serverApp::stop));

        Thread.currentThread().join();
    }
}