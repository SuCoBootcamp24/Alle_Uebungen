public class Join {
    public static void main(String[] args) {
        // Join von Hallo Welt !
        // die zwischenzeichen können verändert werden
    
        String space = args[args.length - 1];
        
        if (space.equals("_")) space = " ";

        String text = String.join(space, args);

        System.out.println(text.substring(0, text.length()- 2));


    }
}
