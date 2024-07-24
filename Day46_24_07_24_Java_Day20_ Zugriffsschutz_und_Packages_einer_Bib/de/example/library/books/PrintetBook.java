package example.library.books;

import example.library.interfaces.Readable;

public class PrintetBook extends Book implements Readable {

    private double weight;

    private boolean isBorrowed;

    public PrintetBook(String title, String author, String isbn, int year, double weight) {
        super(title, author, isbn, year);
        this.weight = weight;
        this.isBorrowed = false;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void ship() {
        System.out.println("Shipping printet book...");
    }

    @Override
    public void read() {
        System.out.println("the first page is opened...");
        System.out.println("...the last page is read and the book is closed");
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
