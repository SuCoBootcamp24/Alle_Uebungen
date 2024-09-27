public class Wuerfel {
    public static void main(String[] args) {
            // Schreibe ein Programm, dass so lange Zufallszahlen würfelt und ausgibt, bis eine 6 gewürfelt wurde. Benutze dafür die Methode Math.random() aus der Java Math Standardbibliothek. 
            // Kleiner Tip: Achte auf den Wertebereich
            // Bonus: Wenn beim ersten Mal würfeln direkt die 6 erreicht wurde, soll eine Zusatzausgabe ( z.B. “WOW ! Beim ersten Treffer eine 6 ! ”) erscheinen:

        int counter = 0;
        int dice;

        while(true) {
            dice = (int) (Math.random() * (7 - 1)) + 1;
            if (dice == 6) {
                if ( counter == 1) System.out.println("WOW ! Beim ersten Treffer eine 6 ! ");
                System.out.println(dice + " Glückwunsch");
                break;
            } else {
                System.out.println(dice);

            }
        }
    }
}
