package java_intro.week12.HW_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java_intro.week12.HW_12.ChatServer.broadcast;
import static java_intro.week12.HW_12.ChatServer.removeClient;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private PrintWriter out;
    private String username;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(socket.getInputStream()));
                PrintWriter out = new
                        PrintWriter(socket.getOutputStream(), true)
        ) {
            this.out = out;
            out.println("Welcome to the chat! Please enter your username:");
            username = in.readLine();
            DatabaseHelper.saveUser(username);
            broadcast(username + " has joined the chat.", this);
            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                String formattedMessage = username + ": " +
                        message;
                DatabaseHelper.saveMessage(username,
                        message);
                System.out.println(formattedMessage);
                broadcast(formattedMessage, this);
            }
        } catch (IOException e) {
            System.err.println("Error handling client: " +
                    e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Error closing socket: "
                        + e.getMessage());
            }
            removeClient(this);
            broadcast(username + " has left the chat.",
                    this);
        }
    }

    void sendMessage(String message) {
        out.println(message);
    }
}

