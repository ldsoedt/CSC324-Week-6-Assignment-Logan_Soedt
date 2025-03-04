import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple To-Do List application that allows users to:
 * 1. Add tasks
 * 2. View tasks
 * 3. Remove tasks
 * 4. Exit the program
 *
 * Uses an ArrayList to store tasks and Scanner for user input.
 */
public class ToDoListApp {
    // Stores the list of tasks
    private static ArrayList<String> tasks = new ArrayList<>();
    private static ArrayList<Int> priorities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        int choice; // Stores user menu choice

        // Loop to continuously show menu until user exits
        do {
            // Display menu options
            System.out.println("\n--- To-Do List ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            // Read user input (menu choice)
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character left after nextInt()

            // Handle user choice using a switch statement
            switch (choice) {
                case 1 -> addTask(scanner); // Call method to add a task
                case 2 -> viewTasks(); // Call method to display tasks
                case 3 -> removeTask(scanner); // Call method to remove a task
                case 4 -> System.out.println("Exiting..."); // Exit message
                default -> System.out.println("Invalid choice. Try again."); // Handle invalid input
            }
        } while (choice != 4); // Loop until user selects option 4 (Exit)

        scanner.close(); // Close scanner to prevent memory leaks
    }

    /**
     * Method to add a new task to the list.
     * @param scanner Scanner object for user input.
     */
    private static void addTask(Scanner scanner) {
        System.out.print("Enter task: ");
        String task = scanner.nextLine(); // Read task from user
        tasks.add(task); // Add task to the list
        assignPriority(scanner);
        System.out.println("Task added!"); // Confirmation message
    }
    /**
     * Method to add priority to the tasks
     */

    private static void assignPriority(Scanner scanner) {
        try{
             System.out.print("Enter task priority (higher numbers = higher priority): ")
            int priority = Integer.parseInt(scanner.nextLine());
            priorities.add(priority);

        }catch(NumberFormatException e){
            System.out.println("Error: Invalid string format. Cannot convert to integer.");
        }
    }

    /**
     * Method to display all tasks in the list.
     */
    private static void viewTasks() {
        if (tasks.isEmpty()) { // Check if the list is empty
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour Tasks:");
            // Loop through the list and display each task with a number
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i) + "Priority level: " + priorities.get(i));
            }
        }
    }

    /**
     * Method to remove a task from the list.
     * @param scanner Scanner object for user input.
     */
    private static void removeTask(Scanner scanner) {
        viewTasks(); // Show current tasks before asking for input
        if (tasks.isEmpty()) return; // If no tasks, exit method

        System.out.print("Enter task number to remove: ");
        int index = scanner.nextInt(); // Get task number from user

        // Validate the task number before removing
        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1); // Remove task (index is 1-based, ArrayList is 0-based)
            priorities.remove(index - 1); //removed the task's priority
            System.out.println("Task removed."); // Confirmation message
        } else {
            System.out.println("Invalid task number."); // Handle invalid input
        }
    }
}
