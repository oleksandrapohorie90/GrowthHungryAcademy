package java_intro.week12.HW_12;

import java.io.BufferedReader;
import java.io.IOException;

public class MessageListener implements Runnable {
    @Override
    public void run() {
        String message;
        try {
            BufferedReader reader = null;
            while ((message = reader.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            System.err.println("Disconnected from the server.");
                    //closeResources();
        }
    }

    public static void main(String[] args) {
        String host = "localhost"; // Default host
        int port = 12345; // Default port
        new ChatClient(host, port);
    }
}
