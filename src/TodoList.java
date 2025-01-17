import java.util.ArrayList;
import java.util.Collections;

public class TodoList {

    public static void main(String[] args) {

    }
    private String owner;
    private ArrayList<Task> tasks;

    public TodoList(String owner) {
        this.owner = owner;
        this.tasks = new ArrayList<Task>();
    }

    public boolean addTask(String name, int urgency) {
        for (Task task: tasks) {
            if (task.getName().equals(name))
                return false;
        }
        tasks.add(new Task(name, urgency));
        return true;
    }

    public boolean removeTask(String name) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(name)) {
                tasks.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateTaskUrgency(String name, int urgency) {

        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.setUrgency(urgency);
                return true;
            }
        }
        return false;
    }

    /**
     * The method mostUrgent will return the name of the task that is the most urgent (i.e. the task with the
     * highest urgency). If there are multiple tasks whose urgency is equal to the maximum, the first task
     * with that urgency will be returned.
     * @return the name of the task with the current highest urgency (a String).
     */
    public String mostUrgent() {
        String mostUrgentName = "No";
        int urgency = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getUrgency() > urgency) {
                mostUrgentName = tasks.get(i).getName();
                urgency = tasks.get(i).getUrgency();
            }
        }
        return mostUrgentName;
    }

    /**
     * The method averageUrgency will return the average (arithmetic mean) of the urgency across all tasks
     * @return the average urgency across all tasks (a double).
     */
    public double averageUrgency() {
        int sum = 0;
        int divisor = 0;
        for (int i = 0; i < tasks.size(); i++) {
            sum += tasks.get(i).getUrgency();
            divisor++;
        }
        return (double) sum /divisor;
    }

    /**
     * The method toString will return all tasks with their urgency in the form of a String.
     * The returned String will be in the following format:
     *
     * To-do List of [owner]
     * [Task 1] [tab] [urgency]
     * [Task 2] [tab] [urgency]
     * [Task 3] [tab] [urgency]
     * [Task 4] [tab] [urgency]
     * ...
     * @return the printable representation of the to-do list (a String).
     *
     * BONUS Challenge:  Sort your to-do list in descending order of urgency
     */
    /*public static ArrayList<Task> sorter(ArrayList<Task> tasks) {
        int mostUrgent = 0;
        ArrayList<Task> thing = new ArrayList<Task>();
        ArrayList<Task> temp = tasks;
        while (!temp.isEmpty()) {
            for (int i = 0; i < tasks.size(); i++) {
                if (temp.get(i).getUrgency() > mostUrgent) {
                    mostUrgent = temp.get(i).getUrgency();
                }
            }
            thing.add(temp.get(mostUrgent));
            temp.remove(mostUrgent);
        }
        return thing;
    }
    public String toStringSorted() {
        ArrayList<Task> temp = sorter(tasks);
        String thing = "To-do List of " + owner;
        for (int i = 0; i < tasks.size(); i++) {
            thing += ("\n" + toText(i));
        }
        System.out.println(thing);
        return thing;    } */
    public String toString() {
        String thing = "To-do List of " + owner;
        for (int i = 0; i < tasks.size(); i++) {
            thing += ("\n" + toText(i));
        }
        System.out.println(thing);
        return thing;
    }
    public String toText(int index) {
        return (tasks.get(index).getName() + "\t" + tasks.get(index).getUrgency());
    }
    /**This is my method that I'll use to sort the results*/


}
