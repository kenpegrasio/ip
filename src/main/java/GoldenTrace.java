import java.util.Scanner;
import java.util.Vector;

public class GoldenTrace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<String> tasks = new Vector<>();

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
            if (line.equals("list")) {
                System.out.println("    ____________________________________________________________\n");
                int counter = 1;
                for (String task : tasks) {
                    System.out.println("    " + counter + ". " + task);
                    counter++;
                }
                System.out.println("    ____________________________________________________________\n");
            } 
            else {
                System.out.println("    ____________________________________________________________\n");
                System.out.println("    added: " + line);
                System.out.println("    ____________________________________________________________\n");
                tasks.add(line);
            }
            line = scanner.nextLine();
        }

        /* Goodbye */
        System.out.println("    ____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");

        scanner.close();
    }
}
