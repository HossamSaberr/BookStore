package Test;

import Models.*;
import service.BookStore;

public class BookStoreTest {
    public void Test() {
        BookStore store = new BookStore();

        store.addBook(new PaperBook("666", "Clean Code" , "Homz", 2015, 35.99, 5));
        store.addBook(new EBook("2005", "Effective Java", "Homz" , 2020, 25.00, "PDF"));
        store.addBook(new ShowcaseBook("S001", "Quantum Physics Demo", "Homz" , 2022, 0));

        store.listBooks();
        System.out.println();

        store.buyBook("2005", 1, "reader@mail.com" , "");
        store.buyBook("666", 2, "user@example.com", "Cairo, Egypt");

        store.removeOutdatedBook(2025 , 9);
    }
}
