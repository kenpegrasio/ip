package goldentrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import goldentrace.type.Deadline;
import goldentrace.type.Event;
import goldentrace.type.TaskList;
import goldentrace.type.ToDo;

import java.nio.file.Path;

public class Storage {
    private static final String FILENAME = "data.txt";

    public Storage() {
    }

    public TaskList load() throws GoldenTraceException {
        Path path = Paths.get(FILENAME);
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new GoldenTraceException("Failed to create storage file!");
            }
            return new TaskList();
        }

        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new GoldenTraceException("Failed to read lines in " + FILENAME);
        }
        TaskList taskList = new TaskList();
        for (String line : lines) {
            String[] arguments = line.split("\\|");
            if (arguments.length == 0) {
                continue;
            }
            if (arguments.length < 3) {
                throw new GoldenTraceException("Invalid format found in " + FILENAME);
            }
            for (int i = 0; i < arguments.length; i++) {
                arguments[i] = arguments[i].trim();
            }

            String identifier = arguments[0];
            String doneString = arguments[1];
            if (!doneString.equals("1") && !doneString.equals("0")) {
                throw new GoldenTraceException("Invalid format found in " + FILENAME);
            }

            switch (identifier) {
                case "T": {
                    if (arguments.length != 3) {
                        throw new GoldenTraceException("Invalid format found in " + FILENAME);
                    }
                    String description = arguments[2];
                    taskList.addTask(new ToDo(description, doneString.equals("1")));
                    break;
                }

                case "D": {
                    if (arguments.length != 4) {
                        throw new GoldenTraceException("Invalid format found in " + FILENAME);
                    }
                    String description = arguments[2];
                    String by = arguments[3];
                    taskList.addTask(new Deadline(description, doneString.equals("1"), by));
                    break;
                }

                case "E": {
                    if (arguments.length != 5) {
                        throw new GoldenTraceException("Invalid format found in " + FILENAME);
                    }
                    String description = arguments[2];
                    String from = arguments[3];
                    String to = arguments[4];
                    taskList.addTask(new Event(description, doneString.equals("1"), from, to));
                    break;
                }

                default: {
                    throw new GoldenTraceException("Invalid format found in " + FILENAME);
                }
            }
        }
        return taskList;
    }

    public void store(TaskList taskList) throws GoldenTraceException {
        Path path = Paths.get(FILENAME);
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new GoldenTraceException("Failed to create storage file!");
            }
        }
        try {
            Files.write(path, "".getBytes());
            for (int i = 0; i < taskList.getSize(); i++) {
                Files.write(path, (taskList.getTask(i).toDatabaseString() + "\n").getBytes(),
                        java.nio.file.StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new GoldenTraceException(e.getMessage());
        }
    }
}
