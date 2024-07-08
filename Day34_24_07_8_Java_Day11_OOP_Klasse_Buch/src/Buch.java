import java.util.HashMap;
import java.util.Map;

public class Buch {
    // Attribute titel, autor, isbn und seitenzahl hat
    public static HashMap<String, Buch> buchList = new HashMap<>();

    private String title;
    private String autor;
    private String isbn;
    private int seitenanzahl;

    public Buch(String titel, String autor, String isbn, int seitenanzahl) {
        this.title = titel;
        this.autor = autor;
        this.isbn = isbn;
        this.seitenanzahl = seitenanzahl;
        buchList.put(isbn, this);
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

  
    public String getAutor() {
        return autor;
    }

    
    public void setAutor(String autor) {
        this.autor = autor;
    }

  
    public String getIsbn() {
        return isbn;
    }

    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

   
    public int getSeitenanzahl() {
        return seitenanzahl;
    }

    
    public void setSeitenanzahl(int seitenanzahl) {
        this.seitenanzahl = seitenanzahl;
    }


    public void druckeDetails(){
        System.out.println(title + " " + autor + " " + isbn + " " + seitenanzahl);
    }



    public static Buch sucheNachISBN(String isbn) {
        for (Map.Entry<String, Buch> buchObj : buchList.entrySet()) {
            if (buchObj.getKey().equals(isbn)) return buchObj.getValue();
        }
        return null;
    }

}