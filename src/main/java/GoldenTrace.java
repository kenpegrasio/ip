import java.util.Scanner;

public class GoldenTrace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int numberOfTasks = 0;

        /* Greeting */
        String logo = "       _____ _______\n"
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
            if (line.isEmpty()) {
                continue;
            }
            if (line.startsWith("list")) {
                System.out.println("    ____________________________________________________________\n");
                for (int i = 0; i < numberOfTasks; i++) {
                    System.out.println("    " + (i + 1) + "." + tasks[i]);
                }
                System.out.println("    ____________________________________________________________\n");
            } else if (line.startsWith("mark")) {
                String[] stringParts = line.split(" ");
                if (stringParts.length == 1) {
                    System.out.println("    ____________________________________________________________\n");
                    System.out.println("    Please follow the format 'mark [number]'!");
                    System.out.println("    ____________________________________________________________\n");
                } else {
                    int index = Integer.parseInt(stringParts[1]) - 1;
                    tasks[index].mark();
                    System.out.println("    ____________________________________________________________\n");
                    System.out.println("    Nice! I've marked this task as done:\n");
                    System.out.println("        " + tasks[index]);
                    System.out.println("    ____________________________________________________________\n");
                }
            } else if (line.startsWith("unmark")) {
                String[] stringParts = line.split(" ");
                if (stringParts.length != 2) {
                    System.out.println("    ____________________________________________________________\n");
                    System.out.println("    Please follow the format 'unmark [number]'!");
                    System.out.println("    ____________________________________________________________\n");
                } else {
                    int index = Integer.parseInt(stringParts[1]) - 1;
                    tasks[index].unmark();
                    System.out.println("    ____________________________________________________________\n");
                    System.out.println("    Nice! I've marked this task as done:\n");
                    System.out.println("        " + tasks[index]);
                    System.out.println("    ____________________________________________________________\n");
                }
            } else if (line.startsWith("todo")) {
                tasks[numberOfTasks] = new ToDo(line.substring(5));
                System.out.println("    ____________________________________________________________\n");
                System.out.println("    Got it. I've added this task: ");
                System.out.println("        " + tasks[numberOfTasks]);
                System.out.println("    Now you have " + (numberOfTasks + 1) + " tasks in the list.");
                System.out.println("    ____________________________________________________________\n");
                numberOfTasks++;
            } else if (line.startsWith("deadline")) {
                String[] stringParts = line.split("/");
                if (stringParts.length != 2 || !stringParts[1].startsWith("by")) {
                    System.out.println("    ____________________________________________________________\n");
                    System.out.println("    Please follow the format 'deadline [description] /by [deadline]'!");
                    System.out.println("    ____________________________________________________________\n");
                } else {
                    tasks[numberOfTasks] = new Deadline(stringParts[0].substring(9), stringParts[1].substring(3));
                    System.out.println("    ____________________________________________________________\n");
                    System.out.println("    Got it. I've added this task: ");
                    System.out.println("        " + tasks[numberOfTasks]);
                    System.out.println("    Now you have " + (numberOfTasks + 1) + " tasks in the list.");
                    System.out.println("    ____________________________________________________________\n");
                    numberOfTasks++;
                }
            } else if (line.startsWith("event")) {
                String[] stringParts = line.split("/");
                if (stringParts.length != 3 || !stringParts[1].startsWith("from") || !stringParts[2].startsWith("to")) {
                    System.out.println("    ____________________________________________________________\n");
                    System.out.println(
                            "    Please follow the format 'event [description] /from [starting time] /to [ending time]'!");
                    System.out.println("    ____________________________________________________________\n");
                } else {
                    tasks[numberOfTasks] = new Event(stringParts[0].substring(6), stringParts[1].substring(5),
                            stringParts[2].substring(3));
                    System.out.println("    ____________________________________________________________\n");
                    System.out.println("    Got it. I've added this task: ");
                    System.out.println("        " + tasks[numberOfTasks]);
                    System.out.println("    Now you have " + (numberOfTasks + 1) + " tasks in the list.");
                    System.out.println("    ____________________________________________________________\n");
                    numberOfTasks++;
                }
            } else {
                System.out.println("    ____________________________________________________________\n");
                System.out.println("    Sorry, I don't understand what you say! " + line);
                System.out.println("    ____________________________________________________________\n");
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
