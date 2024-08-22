import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KillJoy {
    private String welcomeString = "   Hello! I'm KillJoy \n   I'm GENIUS!!!\n   What can I do for you?\n" +
                                   "   ------------------------------------";
    private String exitString = "   ------------------------------------\n" +
                                "    Bubyyeee & Don't Stwesszz. Time to hide now!!\n" +
                                "   ------------------------------------";
    private String logoString = "   ------------------------------------\n" +
                                "    _  ___ _ _      _             \n" +
                                "   | |/ (_) | |    | |            \n" +
                                "   | ' / _| | |    | | ___  _   _ \n" +
                                "   |  < | | | |_   | |/ _ \\| | | |\n" +
                                "   | . \\| | | | |__| | (_) | |_| |\n" +
                                "   |_|\\_\\_|_|_|\\____/ \\___/ \\__, |\n" +
                                "                             __/ |\n" +
                                "                            |___/ \n" +
                                "   ------------------------------------";
    private String markString = "Ayee Yooo! I've marked this task okaayyyyy:";
    private String unmarkString = "Yo big guy! I've unmarked this for you:";
    private ArrayList<Task> taskList = new ArrayList<>();
    private int taskCount = 0;

    public void start() {
        System.out.println(this.logoString);
        System.out.println(this.welcomeString);
        Scanner user = new Scanner(System.in);

        while(true) {
            String input = user.nextLine();
            int taskNum;
            String[] inputAsList = input.split(" ");

            if (inputAsList[0].equals("bye")) {
                System.out.println(this.exitString);
                break;
            } else if (inputAsList[0].equals("list")){
                this.printTaskList();
            } else if (inputAsList[0].equals("mark")) {
                taskNum = Integer.parseInt(inputAsList[1]) - 1;
                this.taskList.get(taskNum).changeStatus();
                this.printTask(this.taskList.get(taskNum));
            } else if (inputAsList[0].equals("unmark")) {
                taskNum = Integer.parseInt(inputAsList[1]) - 1;
                this.taskList.get(taskNum).changeStatus();
                this.printTask(this.taskList.get(taskNum));
            }
            else {
                this.processUserInput(input);
            }
        }
    }

    private void processUserInput(String input) {
        int taskNum;
        String[] inputSplit = input.split("/");
        String[] inputSplitBySpace = inputSplit[0].split(" ");
        String typeOfTask = inputSplitBySpace[0];
        String description = inputSplitBySpace[1];

        System.out.println("   ------------------------------------");
        if (typeOfTask.equals("todo")) {
            taskList.add(new Todo(description));
        } else if (typeOfTask.equals("deadline")) {
            String by = inputSplit[1].replaceFirst("by ", "");
            taskList.add(new Deadline(description, by));
        } else if (typeOfTask.equals("event")) {
            String from = inputSplit[1].replaceFirst("from ", "");
            String to = inputSplit[2].replaceFirst("to ", "");
            taskList.add(new Event(description, from, to));
        }
        taskCount++;
        System.out.println("    What siaaa!! Added this task:");
        System.out.println("    " + this.taskList.get(taskCount - 1));
        if (taskCount == 1) {
            System.out.println("    Now you have " + taskCount + " task in the list.");
        } else {
            System.out.println("    Now you have " + taskCount + " tasks in the list.");
        }
        System.out.println("   ------------------------------------");
    }


    private void printTask(Task task) {
        System.out.println("   ------------------------------------");
        System.out.println("    " + markString + "\n        " + task);
        System.out.println("   ------------------------------------");
    }

    private void printTaskList() {
        System.out.println("    ------------------------------------");
        System.out.println("    Here are your tasks lah!! Don't die:");
        for (int i = 0; i < this.taskCount; i++) {
            System.out.println("    " + (i + 1) + ". " + this.taskList.get(i));
        }
        System.out.println("   ------------------------------------");
    }

    public static void main(String[] args) {
        KillJoy kj = new KillJoy();
        kj.start();
    }
}
