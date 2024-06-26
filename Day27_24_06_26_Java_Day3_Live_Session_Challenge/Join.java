public class Join {
    public static void main(String[] args) {
        // Live Session Challenge 3
        // Join the args[] argumentes 
        // The intermediate signs can be changed
    
        String space = args[args.length - 1];
        
        if (space.equals("_")) space = " ";

        String text = String.join(space, args);

        System.out.println(text.substring(0, text.length()- 2));


    }
}
