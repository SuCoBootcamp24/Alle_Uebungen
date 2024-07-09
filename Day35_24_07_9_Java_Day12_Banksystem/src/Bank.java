public class Bank {
    public static void main(String[] args) {
        
      Bankkonto konto1 = new Bankkonto("Reiner Zufall", "1232145");

      Bankkonto konto2 = new Bankkonto("Fixi Hartmann", "1232145");

      konto1.getKontoinformationen();
      konto1.einzahlen(30.0f);
      konto1.einzahlen(-30.1f);
      konto1.getKontoinformationen();
      konto1.abheben(20.00);
      konto1.getKontoinformationen();
      System.out.println(konto1.abheben(20.00));
    
      konto1.getKontoinformationen();

      konto1.einzahlen(50.0);
      konto1.getKontoinformationen();
      konto2.getKontoinformationen();
      konto1.ueberweisen(konto2, 50.00);

      konto1.getKontoinformationen();
      konto2.getKontoinformationen();

      konto1.kontoauszug();

      System.out.println("----------------");

      konto2.kontoauszug();
    }
}