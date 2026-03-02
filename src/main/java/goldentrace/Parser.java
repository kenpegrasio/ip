package goldentrace;

import goldentrace.command.Command;
import goldentrace.command.DeadlineCommand;
import goldentrace.command.DeleteCommand;
import goldentrace.command.EventCommand;
import goldentrace.command.ListCommand;
import goldentrace.command.MarkCommand;
import goldentrace.command.TodoCommand;
import goldentrace.command.UnmarkCommand;
import goldentrace.type.TaskList;

public class Parser {
    private TaskList taskList;
    private UserInterface ui;

    public Parser(TaskList taskList, UserInterface ui) {
        this.taskList = taskList;
        this.ui = ui;
    }

    public Command parse(String input) throws GoldenTraceException {
        if (input.trim().isEmpty()) {
            throw new GoldenTraceException("Please provide an input!");
        }

        String[] tokens = input.trim().split(" ", 2);
        String command = tokens[0];

        switch (command) {
            case "list": {
                if (tokens.length != 1) {
                    throw new GoldenTraceException("Invalid format. Expected 'list'!");
                }
                return new ListCommand(taskList, ui);
            }

            case "mark": {
                if (tokens.length != 2) {
                    throw new GoldenTraceException("Invalid format. Expected 'mark [number]'!");
                }
                try {
                    int index = Integer.parseInt(tokens[1]) - 1;
                    return new MarkCommand(taskList, ui, index);
                } catch (NumberFormatException ex) {
                    throw new GoldenTraceException("Invalid format. Expected 'mark [number]'!");
                }
            }

            case "unmark": {
                if (tokens.length != 2) {
                    throw new GoldenTraceException("Invalid format. Expected 'unmark [number]'!");
                }
                try {
                    int index = Integer.parseInt(tokens[1]) - 1;
                    return new UnmarkCommand(taskList, ui, index);
                } catch (NumberFormatException ex) {
                    throw new GoldenTraceException("Invalid format. Expected 'unmark [number]'!");
                }
            }

            case "todo": {
                if (tokens.length != 2) {
                    throw new GoldenTraceException("Invalid format. Expected 'todo [description]'!");
                }
                return new TodoCommand(taskList, ui, tokens[1]);
            }

            case "deadline": {
                if (tokens.length != 2) {
                    throw new GoldenTraceException("Invalid format. Expected 'deadline [description] /by [deadline]'!");
                }
                String[] arguments = tokens[1].split("/");
                if (arguments.length != 2 || !arguments[1].startsWith("by")) {
                    throw new GoldenTraceException("Invalid format. Expected 'deadline [description] /by [deadline]'!");
                }
                return new DeadlineCommand(taskList, ui, arguments[0], arguments[1].substring("by".length() + 1));
            }

            case "event": {
                if (tokens.length != 2) {
                    throw new GoldenTraceException(
                            "Invalid format. Expected 'event [description] /from [starting time] /to [ending time]'!");
                }
                String[] arguments = tokens[1].split("/");
                if (arguments.length != 3 || !arguments[1].startsWith("from") || !arguments[2].startsWith("to")) {
                    throw new GoldenTraceException(
                            "Invalid format. Expected 'event [description] /from [starting time] /to [ending time]'!");
                }
                return new EventCommand(taskList, ui, arguments[0], arguments[1].substring("from".length() + 1),
                        arguments[2].substring("to".length() + 1));
            }

            case "delete": {
                if (tokens.length != 2) {
                    throw new GoldenTraceException("Invalid format. Expected 'delete [number]'!");
                }
                try {
                    int index = Integer.parseInt(tokens[1]) - 1;
                    return new DeleteCommand(taskList, ui, index);
                } catch (NumberFormatException ex) {
                    throw new GoldenTraceException("Invalid format. Expected 'unmark [number]'!");
                }
            }

            default:
                throw new GoldenTraceException("Sorry, I don't understand what you say!");
        }
    }
}
