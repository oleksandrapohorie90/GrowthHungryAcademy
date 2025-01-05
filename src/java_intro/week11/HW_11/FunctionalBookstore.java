package java_intro.week11.HW_11;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalBookstore {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book(1, "Head First Java", "Kathy Sierra & Bert Bates", 32.99, 4.7),
                new Book(2, "Java: A Beginner's Guide", "Herbert Schildt", 29.99, 4.6),
                new Book(3, "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", 35.99, 4.8),
                new Book(4, "Effective Java", "Joshua Bloch", 45.99, 4.6),
                new Book(5, "Think Java: How to Think Like a Computer Scientist", "Allen B. Downey & Chris Mayfield", 24.99, 4.5),
                new Book(6, "Introduction to Programming in Java", "Robert Sedgewick & Kevin Wayne", 40.00, 4.4),
                new Book(7, "Java Programming for Absolute Beginners", "Nathan Clark", 21.99, 4.4),
                new Book(8, "Learn Java in One Day and Learn It Well", "L.C. Chan", 19.99, 4.3),
                new Book(9, "Core Java Volume I – Fundamentals", "Cay S. Horstmann", 49.99, 4.5),
                new Book(10, "Java Programming: From Problem Analysis to Program Design", "D.S. Malik", 79.99, 4.3)
        );
        //1.Filter Books: Return a list of books with a rating of 4.0 or higher.
        System.out.println("All books with rating 4.5 or higher: ");
        List<Book> higherRatedBooks =
        books.stream()
                .filter(book->book.getRating() >= 4.5)
                .toList();
        higherRatedBooks.forEach(System.out::println);
        //2. Find Expensive Books: Find the top 3 most expensive books.








    }
}
