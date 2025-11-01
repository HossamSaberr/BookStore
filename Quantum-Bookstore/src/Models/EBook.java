package Models;

import service.delivery.Deliverable;
import service.delivery.MailService;

public class EBook extends Book implements Deliverable{

    private String fileType;
    public EBook(String isBn, String title, String author, int year, double price , String fileType) {
        super(isBn, title, author, year, price);
        this.fileType = fileType;
    }

    @Override
    public void buy(int quantity, String email, String address) {
        System.out.println("Paid amount: $" + (price * quantity));
        deliver(email, address);
    }

    @Override
    public void deliver(String email, String address) {
        MailService.send(email);
    }
}
