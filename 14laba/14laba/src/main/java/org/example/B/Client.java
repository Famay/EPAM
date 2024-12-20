package org.example.B;


import java.io.*;
import java.net.*;


public class Client {
    private static final String PROXY_HOST = "localhost";
    private static final int PROXY_PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket = new Socket(PROXY_HOST, PROXY_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to the proxy server");


            System.out.print("Enter message to send to proxy: ");
            String message = userInput.readLine();
            out.println(message);

            
            String response = in.readLine();
            System.out.println("Response from server (via proxy): " + response);

        } catch (IOException e) {
            System.err.println("Error in client-server communication: " + e.getMessage());
        }
    }
}