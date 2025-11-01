package Models;

import service.delivery.Deliverable;
import service.delivery.ShippingService;

public class PaperBook extends Book implements Deliverable {

    public int stock;

    public PaperBook(String isBn, String title, String author, int year, double price , int stock) {
        super(isBn, title, author, year, price);
        this.stock = stock;
    }

    @Override
    public void buy(int quantity, String email, String address) {
        if (quantity > stock) throw new RuntimeException("Not enough stock for " + title);
        stock -= quantity;
        System.out.println("Paid amount: $" + (price * quantity));
        deliver(email, address);
    }

    @Override
    public void deliver(String email, String address) {
        ShippingService.send(address);
    }
}
