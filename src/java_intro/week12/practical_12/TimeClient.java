package java_intro.week12.practical_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;
    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(socket.getInputStream()))) {
            System.out.println("Connected to server");
            String serverTime = in.readLine();
            System.out.println("Server time: " + serverTime);
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
