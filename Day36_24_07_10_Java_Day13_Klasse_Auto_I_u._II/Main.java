public class Main {
    public static void main(String[] args){
        Auto bmw1 = new Auto("BMW", "325 E36", 1998);

        Fahrer fahrer1 = new Fahrer("Reiner", "Zufall", (byte) 58);
        Fahrer fahrer2 = new Fahrer("Speedy", "Gonzales", (byte) 18);
        Fahrer fahrer3 = new Fahrer("Lisa", "Mustermann", (byte) 17);

        bmw1.getDetails();
        fahrer1.fahren(bmw1, 20);
        bmw1.tanken(50.0);
        fahrer1.fahren(bmw1, 20);
        bmw1.getDetails();

        //fahrer1.fahren(bmw1, -20);  // IllegalArgumentException: Kilometer dürfen nicht negativ sein
        System.out.println("");
        fahrer2.fahren(bmw1, 30);
        System.out.println("");
        fahrer3.fahren(bmw1, 5);  //  DriverIsUndeEighteen: Der Fahrer Darf das Fahrzeug nicht Fahren (Alter < 18J)

        bmw1.pruefeService();

        System.out.println(bmw1.reichweiteBerechnen() + " km Restreichweite");
        
    }
}


