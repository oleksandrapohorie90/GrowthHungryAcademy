package java_intro.week12.HW_12;

import java.io.IOException;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class ChatServer {
    /**
     * Create a simple, multi-threaded online chat application using Java. This project will integrate
     * concepts of concurrency, SQL for data persistence, and networking for communication.
     * <p>
     * Key Features:
     * 1. Multi-threading:
     * ○ Use threads to handle multiple client connections simultaneously.
     * ○ Implement a thread pool for efficient resource management.
     * <p>
     * 2. Networking:
     * ○ Use TCP sockets for client-server communication.
     * ○ Implement protocols for message exchange (e.g., JSON).
     * <p>
     * 3. SQL Database:
     * ○ Store user data, chat history, and other relevant information in a SQL
     * database (e.g., MySQL, PostgreSQL).
     * ○ Use JDBC (Java Database Connectivity) to interact with the database.
     * <p>
     * Breakdown of Tasks:
     * Part 1 - Persistence
     * Manage user data and chat history in MySQL database.
     * <p>
     * Part 2 - Server-side
     * 1. Create a server socket to listen for incoming connections.
     * 2. Handle client connections using threads.
     * 3. Implement message broadcasting and private messaging.
     * <p>
     * Part 3 - Client-side
     * 4. Establish a connection to the server.
     * 5. Allow users to send and receive messages.
     * 6. Handle user input and display messages.
     */

    private static final int PORT = 12345;
    private static final List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new
                ServerSocket(PORT)) {
            System.out.println("Chat server started on port " +
                    PORT);
            DatabaseHelper.initializeDatabase();
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " +
                        clientSocket.getInetAddress());
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            System.err.println("Error starting server: " +
                    e.getMessage());
        }
    }

    static void broadcast(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    static void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

}

