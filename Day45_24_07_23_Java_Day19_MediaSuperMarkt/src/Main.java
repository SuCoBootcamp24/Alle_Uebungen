import device.*;
public class Main {
    public static void main(String[] args) {
       Geraet geraet1 = new Geraet("gerät", "Test Geraet");
        Fernseher fernseher1 = new Fernseher("Fernseher", "Test Fernseher", 50);
        Smartphone smartphone1 = new Smartphone("Smartphone", "Test Smartp", "Android");
        Laptop laptop1 = new Laptop("Laptop", "Test Laptop", "Intel Core");

        Geraet.testGeraet(geraet1);
        System.out.println("----");

        Geraet.testGeraet(fernseher1);
        System.out.println();
        fernseher1.verbindenMitBluetooth();
        System.out.println("-------");

        Geraet.testGeraet(smartphone1);
        System.out.println();
        smartphone1.verbindenMitBluetooth();
        System.out.println();
        smartphone1.verbindenMitInternet();
        System.out.println("--------");

        Geraet.testGeraet(laptop1);
        System.out.println();
        smartphone1.verbindenMitInternet();
        System.out.println("------");
    }
}