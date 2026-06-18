import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagementSystem {
    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(targetTitle)) return b;
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String targetTitle) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comp = books[mid].title.compareToIgnoreCase(targetTitle);
            if (comp == 0) return books[mid];
            if (comp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "1984", "George Orwell"),
            new Book(2, "Brave New World", "Aldous Huxley"),
            new Book(3, "Fahrenheit 451", "Ray Bradbury")
        };
        
        System.out.println("Linear Search for '1984': " + (linearSearch(books, "1984") != null ? "Found" : "Not Found"));
        
        // Binary search requires sorted array by title
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));
        System.out.println("Binary Search for '1984': " + (binarySearch(books, "1984") != null ? "Found" : "Not Found"));
    }
}
/*
Output:
Linear Search for '1984': Found
Binary Search for '1984': Found
*/
