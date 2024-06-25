public class Calc {
    public static void main(String[] args) {

        int a = randomInt();
        int b = randomInt();
        
        System.out.println("zufallszahlen generieren für die Seiten des Rechtecks a = " + a + "    b = " + b);

        System.out.println("umfang U = 2a + 2b");
        System.out.println("= " + circum(a, b));
        System.out.println("");

        System.out.println("Flächeninhalt A = ab");
        System.out.println("= " + area(a, b));
        System.out.println("");
        
        System.out.println("Hypotenose c = Wurzel aus a^2 + b^2");
        System.out.println("= " + hypotenuse(a, b));
        System.out.println("");
        
        System.out.println("Radius des Rechteckes ist r = (Wurzel aus a^2 + b^2) / 2  ");
        System.out.println("= " + (hypotenuse(a, b) / 2));
        System.out.println("");
        
    }


    public static int circum(int a, int b) {
        return 2*a + 2*b;
    }

    public static int area(int a, int b) {
        return a*b;
    }


    public static double hypotenuse(int a, int b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public static int randomInt() {
        return (int) (Math.random() * (100 - 1)) + 1;
    }
}
