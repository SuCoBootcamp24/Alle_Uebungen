public class Calc {
    public static void main(String[] args) {

        byte discount = 40;

        if (args.length > 0) {
        double sum = Double.parseDouble(args[0]);
        sum = sum - (sum * (discount /100.0));

        System.out.println("Rabattierter Preis: " + Math.round(sum*100.0)/100.0);
        } else {
            System.out.println("Bitte einen Preis beim Program Start angeben");
        }

 
    }
}   
