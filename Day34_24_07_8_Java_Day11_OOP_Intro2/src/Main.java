package src;


public class Main {

    // String hersteller;
// float cpuHz; // 3.2f ==> 3.2 GHz
// byte ram;  // zb 16 => 16GB
// int diskSpace; // 512 => 512 GB
// float monitorSize; // 15.6 ==> 15.6"
// float weight; // 1.48 ==> 1.48 kg

// Aufgabe:
// implementiere die Laptop klasse mit einem konstruktor der alle werde akzeptiert
// implementiere getter und setter (attr sind private)
//      baue checks ein beim setten (selber überlegen)
//      hersteller nur "Apple", "Samsung", "Toshiba", "Acer", "HP", "Dell"
// implementiere eine toString methode
// implementiere eine printInfo methode
    
    public static void main(String[] args) {

        Laptop laptop1 = new Laptop("Apple", 3.2f, 16, 512, 15.6f, 1.4f);
        laptop1.printInfo();
    }
}
