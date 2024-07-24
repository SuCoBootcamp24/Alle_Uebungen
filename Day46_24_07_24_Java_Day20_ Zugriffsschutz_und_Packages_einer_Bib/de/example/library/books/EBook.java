package example.library.books;

import example.library.interfaces.Readable;

public class EBook extends Book implements Readable {

    private double fileSize;

    public EBook(String title, String author, String isbn, int year, double fileSize) {
        super(title, author, isbn, year);
        this.fileSize = fileSize;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public void download() {
        System.out.println("Downloading eBook...");
    }

    @Override
    public void read() {
        System.out.println("Opening Reader software to read " + getTitle() + " by " + getAuthor() + ".....");
        System.out.println("Lorem ipsum dolor sit amet, consectetur adip elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,....");
    }
}
