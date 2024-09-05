package killjoy.task;

import java.time.LocalDateTime;

/**
 * Represents a task of type Event.
 */
public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;

    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description, TaskType.EVENT);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getTaskInfo() {
        return "EVENT|" + String.valueOf(isDone ? 1 : 0) + "|" + this.description + "|" +
                String.valueOf(this.from).replace("T", " ") + "|"
                + String.valueOf(this.to).replace("T", " ") + "\n";
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + " (from: " + this.from.format(DATE_TIME_OUTPUT_FORMATTER) + " to: "
                + this.to.format(DATE_TIME_OUTPUT_FORMATTER) + ")";
    }
}
