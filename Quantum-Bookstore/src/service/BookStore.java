package service;

import java.util.*;
import Models.Book;

public class BookStore {
    private Map<String , Book> stocking = new HashMap<>(); // isBn is the key , Book is the value

    public void addBook(Book book) {
        stocking.put(book.getIsBn(), book);
        System.out.println("Added: " + book.getTitle());
    }

    public void removeOutdatedBook(int curYear , int maxYear) {
        Iterator<Map.Entry<String , Book>> it = stocking.entrySet().iterator();
        // now we have an set of all dat
        // why not just use an normal loop ?
        // cause we cannot modified the hash map while looping over it
        while (it.hasNext()) {
            Book book = it.next().getValue();
            if(curYear - book.getYear() > maxYear) {
                System.out.println("Removed outdated book: " + book.getTitle());
                it.remove();
            }
        }
    }

    public void buyBook(String isBn , int quantity , String email , String address) {
        Book b = stocking.get(isBn);
        if (b == null)
            throw new RuntimeException("Book not found with ISBN: " + isBn);
        b.buy(quantity, email, address);
    }

    public void listBooks() {
        System.out.println("\n--- Available books ---");
        for (Book b : stocking.values()) {
            System.out.println(b.getTitle() + " (" + b.getYear() + ")");
        }
    }
}
