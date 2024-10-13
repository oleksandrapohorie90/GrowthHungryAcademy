package java_intro.week3;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Practice2 {
    /**
     * Create a simple Java program that simulates a Library Management System. This program
     * will allow you to:
     * Store a list of books (using an ArrayList).
     * Manage a list of borrowed books (using a HashSet, since borrowed books should be
     * unique).
     * Track book borrow requests in the order they are received (using a Deque).
     * Keep track of how many copies of each book are available in the library (using a HashMap).
     */
    //create a HashMap for book names, keet track of how many books are available
    HashMap<String, Integer> availability = new HashMap<>();
    //borrow requests by book ---- arraylist, deck is a 2sided queue - last in last out
    //if book is not available request should be per book
    //queue per each book
    //HashMap<String, Integer> borrowRequests = new HashMap<>();
    HashMap<String, Queue<String>> borrowRequests = new HashMap<>();

    //to add books to the inventory
    public void addBook(String book, int copies) {
        availability.put(book, availability.getOrDefault(book, 0) + copies);
    }

    //to borrow a book
    public void borrowBook(String book) {
        //if book is available, then decrement availability map, if not then add a pending request
        if (availability.getOrDefault(book, 0) > 0) {
            availability.put(book, availability.get(book) - 1);
        } else {
            if (!borrowRequests.containsKey(book)) {
                borrowRequests.put(book, new LinkedList<>());
            }
            borrowRequests.get(book).add(book);
        }
    }

    //to return a book
    public void returnBook(String book) {
        if (borrowRequests.containsKey(book) && borrowRequests.get(book).size() > 0) {
            borrowRequests.get(book).remove();
        } else {
            availability.put(book, availability.get(book) + 1);
        }
    }
}
