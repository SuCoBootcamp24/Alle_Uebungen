public class Prediction {
    public static void main(String[] args) {
        // 1. Welchen Wert haben a, b und c jeweils am Ende der Anweisung:
         //a)
        int a = 0;
        for(int i = 0; i < 10; i++){ 
                 a +=i ;
          }
          System.out.println(a);
          //Lösung: 45 es werden alle zahlen von 0 - 9 aufadiert
     
         //c) 
        int b = 0;
        for(b = 0; b < 10; b++){ 
            
                 b += b;
          }
         System.out.println(b);
        //Lösung: 15  b verdoppelt sich pro durchlauf


        // d) 
        int c = 0;
        for(int i = 0; i < 10; i++){ 
                 c += c++;
          }
        System.out.println(c);
        //Lösung: bleibt 0 da die rechnung immer wieder 0 ergibt


    }
}
