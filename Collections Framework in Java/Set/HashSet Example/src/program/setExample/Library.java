package program.setExample;

import java.util.HashSet;
import java.util.Set;

public class Library {
    private Set<Book> bookCollection = new HashSet<>();

    public void addBook(Book book) {
        if (bookCollection.add(book)) {
            System.out.println("Book added to the collection.");
        } else {
            System.out.println("This book is already in the collection.");
        }
    }

    public void removeBook(Book book) {
        if (bookCollection.remove(book)) {
            System.out.println("Book removed from the collection.");
        } else {
            System.out.println("This book is not in the collection.");
        }
    }

    public boolean checkBook(Book book) {
        return bookCollection.contains(book);
    }

    public void displayBooks() {
        if (bookCollection.isEmpty()) {
            System.out.println("The library collection is empty.");
        } else {
            for (Book book : bookCollection) {
                System.out.println(book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
            }
        }
    }
}
