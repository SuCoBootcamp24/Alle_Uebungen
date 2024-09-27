public class Join {
    public static void main(String[] args) {
        // Live Session Challenge 3
        // Join the args[] argumentes 
        // The intermediate signs can be changed
    
        String space = args[args.length - 1];

        if (space.equals("_")) space = " ";

        String message = "";    
        for (int i = 0; i < args.length - 1; i++) {
            message += args[i];
            if (i < args.length -2) {
                message += space;
            }
        }

        // or  String message = String.join(space, args);

        System.out.println(message.substring(0, message.length()- 2));


    }
}
