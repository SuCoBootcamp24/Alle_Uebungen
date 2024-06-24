class HelloWorld {
    public static void main(String[] args) {
       // System.out.println(Hello, World!); --->
       // 1. hier werden auf nicht existierende Variablen verwiesen ebenso ist ein ! nicht für ein Variablename nutzbar auch ist das , durch ein + zu ersetzen.
       // 2. ODER wenn es als Wörter angegeben werden sollte so wurde es ebenfalls falsch geschrieben es Fehlen die "" um den Wörtern und das kommer muss durch ein + ersetzt werden.
       
       // 1.
       String Hello = "Hello";
    
       String World = "World!";

       System.out.println(Hello + World);

       // 2.

       System.out.println("Hello" + "World!");

    }
}