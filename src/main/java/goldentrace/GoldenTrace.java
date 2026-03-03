package goldentrace;

import java.util.Scanner;

import goldentrace.command.Command;
import goldentrace.type.TaskList;

public class GoldenTrace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Storage storage = new Storage();
        UserInterface ui = new UserInterface();
        TaskList taskList = new TaskList();
        try {
            taskList = storage.load();
        } catch (GoldenTraceException e) {
            ui.sendError(e.getMessage());
        }
        Parser parser = new Parser(taskList, ui);

        /* Conversation */
        ui.greet();
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("bye")) {
                ui.sayGoodbye();
                break;
            }
            try {
                Command command = parser.parse(input);
                command.execute();
                storage.store(taskList);
            } catch (GoldenTraceException e) {
                ui.sendError(e.getMessage());
            }
        }

        scanner.close();
    }
}
