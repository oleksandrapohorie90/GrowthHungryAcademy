package java_intro.week11.HW_11;

import java.util.List;

public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private double rating;

    public Book(int id, String title, String author, double price, double rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
    /**
     * Implement the following functionalities using lambda expressions and Streams
     * API:
     * 1. Filter Books: Return a list of books with a rating of 4.0 or higher.
     * 2. Find Expensive Books: Find the top 3 most expensive books.
     * 3. Transform Titles: Convert all book titles to uppercase and return them as a
     * list.
     * 4. Sort by Rating and Price: Sort books first by rating (descending) and then
     * by price (ascending).
     * 5. Average Price by Author: Calculate the average price of books for each
     * author.
     * 6. Books by Price Range: Group books into three price ranges: <20, 20-50,
     * >50.
     * =======================
     * Setup Data: Populate a list of books with sample data (at least 10 entries).
     * 2. Implement the Functionalities: Write separate methods for each functionality listed
     * above.
     * 3. Print Results: Display the output of each operation in a user-friendly format.
     * Extra Challenges (Optional)
     * 1. Find the book with the longest title.
     * 2. Count how many books each author has written.
     * 3. Check if all books in the list have a rating greater than 3.0.
     *=========================
     *  Expected Output
     * 1. A list of books with high ratings.
     * 2. The top 3 most expensive books.
     * 3. Transformed titles in uppercase.
     * 4. Books sorted by rating and price.
     * 5. Average price of books for each author.
     * 6. Books grouped by price range.
     */
}
