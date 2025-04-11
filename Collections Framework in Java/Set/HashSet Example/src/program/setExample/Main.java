package program.setExample;

public class Main {
    public static void main(String[] args) {
        // Create a library instance
        Library library = new Library();

        // Create some book instance
        Book book1 = new Book("1234567890", "The Great GatsBy");
        Book book2 = new Book("0987654321", "1984");
        Book book3 = new Book("5647392834", "To Kill a Mockingbird");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Attempt to add a duplicate book
        library.addBook(book1);

        // Display books in the library
        System.out.println("Books currently in the library:");
        library.displayBooks();

        // Check if a specific book is in the library
        if (library.checkBook(book2)) {
            System.out.println("Book 2 was added to the library");
        } else {
            System.out.println("Book 2 was not added to the library");
        }

        // Remove a book from the library
        if (library.checkBook(book3)) {
            library.removeBook(book3);
        }

        // Display books after removal
        System.out.println("Books currently in the library:");
        library.displayBooks();
    }
}
