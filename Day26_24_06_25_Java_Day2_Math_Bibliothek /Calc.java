public class Calc {
    public static void main(String[] args) {

System.out.println("Quadratwurzel berechnen von 7");
        System.out.println(squareRoot(7));
        System.out.println("");

        System.out.println("Potenz berechnen von 5^2");
        System.out.println(pow(5, 2));
        System.out.println("");
        
        System.out.println("Absolute Zahl berechnen von 45.5453");
        System.out.println(absolute(45.5453));
        System.out.println("");
        
        System.out.println("Zahl runden berechnen von 45.5453");
        System.out.println(rounds(45.5453));
        System.out.println("");
        
        System.out.println("Eine Zufällige zahl");
        System.out.println(randomInt());
        System.out.println("");
        
        System.out.println("Natürlicher Logarithmus der Eulerschen Zahl " + Math.E);
        System.out.println(logNum(Math.E));

    }


    public static double squareRoot(double num) {
        return Math.sqrt(num);
    }

    public static double pow(int num, int power) {
        return Math.pow(num, power);
    }


    public static double absolute(double num) {
        return Math.abs(num);
    }

    public static double rounds(double num) {
        return Math.round(num);
    }

    public static int randomInt() {
        return (int) (Math.random() * (10000 - 1)) + 1;
    }

    public static double logNum(double num) {
        return Math.log(num);
    }
}
