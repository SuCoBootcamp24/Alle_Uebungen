public class TempCalc {
 
    public static void main(String[] args) {
        float temp = Float.parseFloat(args[0]);
        System.out.println(temp + " °C sind umgerechnet " + calc(temp) + " °F");
    }


    private static float calc(float temp) {
        return (temp * 9 / 5) + 32;
        }
}
