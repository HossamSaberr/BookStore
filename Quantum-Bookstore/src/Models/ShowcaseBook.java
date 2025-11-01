package Models;

public class ShowcaseBook extends Book{

    public ShowcaseBook(String isbn, String title, String author , int year, double price) {
        super(isbn, title, author , year, price);
    }

    @Override
    public void buy(int quantity, String email, String address) {
        throw new UnsupportedOperationException("Showcase books are not for sale!");
    }
}
