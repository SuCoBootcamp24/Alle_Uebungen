public class Main {
    public static void main(String[] args) {
        
        IntArrayList liste = new IntArrayList();
        liste.add(5);
        liste.add(10);
        liste.add(2);
        liste.add(15);
        liste.add(-19);
        liste.add(34);
        liste.add(19);

        liste.print();

        IntArrayList reversedList = liste.reverse();
        reversedList.print();

        System.out.println(liste.indexOf(19));
        System.out.println(reversedList.indexOf(19));


        System.out.println("Slices:");
        reversedList.slice(0).print();
        reversedList.slice(1).print();
        reversedList.slice(2).print();
        reversedList.slice(2000).print();
        // reversedList.slice(1000).print();
        reversedList.slice(-1).print();
        reversedList.slice(-2).print();
        reversedList.slice(-3).print();
        reversedList.slice(-200).print();
        reversedList.slice(2, -2).print();
        // reversedList.slice(-2, 20).print(); // java.lang.IllegalArgumentException


    }
}