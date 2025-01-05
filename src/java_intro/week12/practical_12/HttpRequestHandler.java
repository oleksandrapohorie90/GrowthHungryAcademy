package java_intro.week12.practical_12;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.logging.Handler;

public class HttpRequestHandler {
/*
Practical Exercise 2: HTTP Request Handler
Develop a Java program that demonstrates the use of HTTP classes by creating an HTTP
Request Handler. This program will simulate a basic HTTP server capable of responding to
GET requests.
Instructions:
1. Setup:
○ Create a server application using Java's HttpServer class from the
com.sun.net.httpserver package.
○ Configure it to listen on a specific port (e.g., 8000).
2. Functionality:
○ Handle basic HTTP GET requests by returning appropriate responses.
○ Implement the following endpoints:
■ /: Respond with a welcome message (e.g., "Welcome to the HTTP
Request Handler!").
■ /time: Respond with the current server time in a readable format.
■ /echo?message=your_message: Echo back the provided message
as part of the response.
3. Enhancements:
○ Log incoming requests with details like the request method, URI, and
timestamp.
○ Return an appropriate error message for unsupported request types (e.g.,
POST).
Guidelines:
● Use HttpServer and HttpHandler classes for managing HTTP requests.
● Implement a custom HttpHandler for each endpoint.
● Ensure proper resource management and exception handling.
Example Output:
1. Server log:
○ "Request received: GET /time at 2024-12-15 10:00:00"
○ "Request received: GET /echo?message=Hello"
2. Client responses:
○ GET /: "Welcome to the HTTP Request Handler!"
○ GET /time: "Current server time: 2024-12-15 10:00:00"
○ GET /echo?message=Hello: "Echo: Hello"
This exercise practices the use of HTTP classes in Java and basic HTTP protocol handling
 */
    public static void main(String[] args) throws IOException {
        int port = 8000;
        HttpServer server = HttpServer.create(new
                InetSocketAddress(port), 0);
        System.out.println("HTTP Server started on port " +
                port);
        server.createContext("/", new RootHandler());
        server.createContext("/time", new TimeHandler());
        server.createContext("/echo", new EchoHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws
                IOException {
            String response = "Welcome to the HTTP Request Handler !";
            sendResponse(exchange, response);
        }
    }

    static class TimeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws
                IOException {
            String currentTime = new
                    SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String response = "Current server time: " +
                    currentTime;
            sendResponse(exchange, response);
        }
    }

    static class EchoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws
                IOException {
            String query = exchange.getRequestURI().getQuery();
            Map<String, String> params = parseQuery(query);
            String message = params.getOrDefault("message",
                    "(no message provided)");
            String response = "Echo: " + message;
            sendResponse(exchange, response);
        }

        private Map<String, String> parseQuery(String query) {
            if (query == null || query.isEmpty()) {
                return Map.of();
            }
            return Map.ofEntries(
                    Arrays.stream(query.split("&"))
                            .map(param -> param.split("=", 2))
                            .map(pair -> Map.entry(pair[0],
                                    pair.length > 1 ? pair[1] : ""))
                            .toArray(Map.Entry[]::new)
            );
        }
    }

    private static void sendResponse(HttpExchange exchange,
                                     String response) throws IOException {
        exchange.sendResponseHeaders(200,
                response.getBytes().length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
