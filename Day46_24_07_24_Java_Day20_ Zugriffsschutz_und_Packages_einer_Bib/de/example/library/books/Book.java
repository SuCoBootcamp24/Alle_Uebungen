package example.library.books;

public abstract class Book {
    private String title;

    protected String author;

    String isbn;

    public int year;

    private boolean canBeBorrowed; // maybe the book ist only for selling.


    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.canBeBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isCanBeBorrowed() {
        return canBeBorrowed;
    }

    public void setCanBeBorrowed(boolean canBeBorrowed) {
        this.canBeBorrowed = canBeBorrowed;
    }
}
