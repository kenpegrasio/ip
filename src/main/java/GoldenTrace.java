import java.util.Scanner;

public class GoldenTrace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* Greeting */
        String logo =
                  "       _____ _______\n"
                + "      / ____|__   __|\n"
                + "     | |  __   | |   \n"
                + "     | | |_ |  | |   \n"
                + "     | |__| |  | |   \n"
                + "     \\_____|  |_|   \n";
        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm\n" + logo);
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________\n");

        /* Conversation block */
        String line = scanner.nextLine();
        while (!line.equals("bye")) {
            System.out.println("    ____________________________________________________________\n");
            System.out.println("    " + line);
            System.out.println("    ____________________________________________________________\n");
            line = scanner.nextLine();
        }

        /* Goodbye */
        System.out.println("    ____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");

        scanner.close();
    }
}
