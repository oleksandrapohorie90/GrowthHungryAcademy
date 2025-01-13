package java_intro.week12.HW_12;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String username;

    public ChatClient(String host, int port) {
        try {
            socket = new Socket(host, port);
            reader = new BufferedReader(new
                    InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new
                    OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your username: ");
            username = scanner.nextLine();
            writer.write(username);
            writer.newLine();
            writer.flush();
// Start a thread to listen for messages from the server
            new Thread(new MessageListener()).start();
// Main thread for sending messages
            while (true) {
                String message = scanner.nextLine();
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println("Error connecting to the server: " + e.getMessage());
            closeResources();
        }
    }

    private void closeResources() {
        try {
            if (reader != null) reader.close();
            if (writer != null) writer.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            System.err.println("Error closing resources: " +
                    e.getMessage());
        }
    }
}
