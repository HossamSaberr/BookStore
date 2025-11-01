package Models;

public abstract class Book {
    protected String isBn;
    protected String title;
    protected String author;
    protected int year;
    protected double price;

    public Book(String isBn , String title , String author , int year , double price) {
        this.isBn = isBn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getIsBn() {
        return isBn;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public abstract void buy(int quantity, String email, String address);
}
