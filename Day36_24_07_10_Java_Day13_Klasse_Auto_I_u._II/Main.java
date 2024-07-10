public class Main {
    public static void main(String[] args){

        //"neues" auto wird gekauft:
        Auto bmw1 = new Auto("BMW", "325 E36", 1998);
        bmw1.getDetails();

        //Fahrer die dieses auto fahren (wollen):
        Fahrer fahrer1 = new Fahrer("Reiner", "Zufall", (byte) 58);
        Fahrer fahrer2 = new Fahrer("Speedy", "Gonzales", (byte) 18);
        Fahrer fahrer3 = new Fahrer("Lisa", "Mustermann", (byte) 17);

        // fahrer versucht zu fahren aber der tank ist leer
        fahrer1.fahren(bmw1, 20);
        System.out.println("");

        
        //er muss tanken
        bmw1.tanken(50.0);
        System.out.println("");


        //nu kann er fahren
        fahrer1.fahren(bmw1, 20);
        bmw1.getDetails();
        System.out.println("");


        // fahrer1 versucht nur rückwärz zu fahren
        //fahrer1.fahren(bmw1, -20);  // IllegalArgumentException: Kilometer dürfen nicht negativ sein
        System.out.println("");
        

        // fahrer2 färt nun 
        fahrer2.fahren(bmw1, 30);
        System.out.println("");


        //fahrer3 versucht zu fahren jedoch ist diese person zu jung und darf nicht fahren
        fahrer3.fahren(bmw1, 5);  //  DriverIsUndeEighteen: Der Fahrer Darf das Fahrzeug nicht Fahren (Alter < 18J)

        System.out.println("");


        //fahrzeug prüfen ob check fellig ist
        bmw1.pruefeService();
        System.out.println("");


        // skipe 15.000 kilometer um pruefeService() zu testen
        bmw1.setKmStand(bmw1.getKmStand() + 15000);
        bmw1.pruefeService();
        System.out.println("");


        // service wird durchgeführt
        bmw1.serviceDurchfueren();
        bmw1.pruefeService();
        System.out.println("");


        // fahrer will eine tour von 600km machen. er läst sich die restkm ausgeben die mit der aktuellen tankfüllung gefahren werden kann
        System.out.println(bmw1.reichweiteBerechnen() + " km Restreichweite");
        System.out.println("");
        fahrer2.fahren(bmw1, 600);
        System.out.println("");
        System.out.println(bmw1.reichweiteBerechnen() + " km Restreichweite");
        System.out.println("");

        //fahrer will den wagen wieder auftanken. tankt aber mehr als das max
        bmw1.tanken(50.00);

        
    }
}


