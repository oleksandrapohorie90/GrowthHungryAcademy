package java_intro.week12.practical_12;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServer {
    /*
    Instructions:
1. Setup:
○ Create a server program that listens on a specified port (e.g., 12345).
○ Create a client program that connects to the server.
2. Functionality:
○ Server:
■ On receiving a request, send the current server time to the client.
○ Client:
■ Connect to the server and display the received time.
3. Enhancements:
○ Format the time in a readable format (e.g., "2024-12-15 10:00:00").
○ Allow multiple clients to connect simultaneously using multithreading.
Guidelines:
● Use ServerSocket and Socket classes for networking.
● Handle exceptions gracefully to avoid crashes.
● Use proper closing of sockets and streams to prevent resource leaks.
Example Output:
1. Server output:
○ "Client connected: 127.0.0.1"
○ "Sent time: 2024-12-15 10:00:00"
2. Client output:
○ "Connected to server"
○ "Server time: 2024-12-15 10:00:00"
This exercise practices key concepts of network programming in Java while avoiding
complex file handling or chat-based applications
     */
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Time Server started on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedWriter out = new BufferedWriter(new
                    OutputStreamWriter(clientSocket.getOutputStream()))) {
                String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                out.write(currentTime);
                out.newLine();
                out.flush();
                System.out.println("Sent time: " + currentTime);
            } catch (IOException e) {
                System.err.println("Client error: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e.getMessage());
                }
            }
        }
    }
}

