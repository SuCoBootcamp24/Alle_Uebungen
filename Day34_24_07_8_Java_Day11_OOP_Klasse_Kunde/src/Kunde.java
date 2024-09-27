
public class Kunde {
    // kundenId, name, email und telefonnummer 

    private String name;
    private String email;
    private String telefonnummer;
    private String kundenId;

    public Kunde(){
    }
    
    public Kunde(String name, String kundenId){
        this.name = name;
        this.kundenId = kundenId;
    }

    public Kunde(String name, String kundenId, String email){
        this(name, kundenId);
        this.email = email;

    }
    
    public Kunde(String name, String kundenId, String email, String telefonnummer){
        this(name, kundenId, email);
        this.telefonnummer = telefonnummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getKundenId() {
        return kundenId;
    }

    public void setKundenId(String kundenId) {
        this.kundenId = kundenId;
    }

    public void printDetails() {
        System.out.println("Kundenname: " + this.name + "email: " + this.email + " Telefon: " + this.telefonnummer + " Kundennummer: " + this.kundenId);
    }



}
