import java.util.Scanner;

public class GoldenTrace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int numberOfTasks = 0;

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
            String[] stringParts = line.split(" ");
            if (stringParts.length == 0) {
                continue;
            }
            if (line.equals("list")) {
                System.out.println("    ____________________________________________________________\n");
                for (int i = 0; i < numberOfTasks; i++) {
                    System.out.println("    " + (i + 1) + "." + tasks[i]);
                }
                System.out.println("    ____________________________________________________________\n");
            } 
            else if (stringParts[0].equals("mark")) {
                if (stringParts.length == 1) {
                    System.out.println("    ____________________________________________________________\n");
                    System.out.println("    Please provide the number of the task that you want to mark as done!");
                    System.out.println("    ____________________________________________________________\n");
                } else {
                    int index = Integer.parseInt(stringParts[1]) - 1;
                    tasks[index].mark();
                    System.out.println("    ____________________________________________________________\n");
                    System.out.println("    Nice! I've marked this task as done:\n");
                    System.out.println("        " + tasks[index]);
                    System.out.println("    ____________________________________________________________\n");
                }
            }
            else if (stringParts[0].equals("unmark")) {
                if (stringParts.length == 1) {
                    System.out.println("    ____________________________________________________________\n");
                    System.out.println("    Please provide the number of the task that you want to unmark!");
                    System.out.println("    ____________________________________________________________\n");
                } else {
                    int index = Integer.parseInt(stringParts[1]) - 1;
                    tasks[index].unmark();
                    System.out.println("    ____________________________________________________________\n");
                    System.out.println("    Nice! I've marked this task as done:\n");
                    System.out.println("        " + tasks[index]);
                    System.out.println("    ____________________________________________________________\n");
                }
            }
            else {
                System.out.println("    ____________________________________________________________\n");
                System.out.println("    added: " + line);
                System.out.println("    ____________________________________________________________\n");
                tasks[numberOfTasks] = new Task(line);
                numberOfTasks++;
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
