import device.*;
import person.Mitarbeiter;

public class Main {
    public static void main(String[] args) {
     Mitarbeiter prakti = new Mitarbeiter();

       Geraet geraet1 = new Geraet("gerät", "Test Geraet");
        Fernseher fernseher1 = new Fernseher("Fernseher", "Test Fernseher", 50);
        Smartphone smartphone1 = new Smartphone("Smartphone", "Test Smartp", "Android");
        Laptop laptop1 = new Laptop("Laptop", "Test Laptop", "Intel Core");

        prakti.testGeraet(geraet1);
        System.out.println("----");

        prakti.testGeraet(fernseher1);
        System.out.println();
        fernseher1.verbindenMitBluetooth();
        System.out.println("-------");

        prakti.testGeraet(smartphone1);
        System.out.println();
        smartphone1.verbindenMitBluetooth();
        System.out.println();
        smartphone1.verbindenMitInternet();
        System.out.println("--------");

        prakti.testGeraet(laptop1);
        System.out.println();
        smartphone1.verbindenMitInternet();
        System.out.println("------");
    }
}