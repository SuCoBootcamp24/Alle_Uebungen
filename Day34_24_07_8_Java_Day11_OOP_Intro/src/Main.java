package src;


public class Main {
    public static void main(String[] args) {



        Person person1 = new Person("Mama", "Lauder", 4);
        Person person2 = new Person("Reiner", "Zufall", 36);
        Person personAufgabe = new Person("Thomas Bauer (36)");
        
        System.out.println(
            person1.getFirstname()
            + " " 
            + person1.getLastname()
            + " (" + person1.getAge() + ")"
        );
        System.out.println(
            person2.getFirstname()
            + " " 
            + person2.getLastname()
            + " (" + person2.getAge() + ")"
        );

        System.out.println(
            personAufgabe.getFirstname()
            + " " 
            + personAufgabe.getLastname()
            + " (" + personAufgabe.getAge() + ")"
        );
        
    }
}
