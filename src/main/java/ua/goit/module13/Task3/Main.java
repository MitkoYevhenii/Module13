package ua.goit.module13.Task3;


import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        User user = new User(2L, 1L, "delectus aut autem", true);

        List<User> openTasks = GetAllOpenTask.getAllOpenTasks(user);
        if (openTasks != null) {
            System.out.println("Open Tasks for User " + user.getId() + ":");
            for (User task : openTasks) {
                System.out.println("Task ID: " + task.getId());
                System.out.println("Title: " + task.getTitle());
                System.out.println("Completed: " + task.isCompleted());
                System.out.println();
            }
        } else {
            System.out.println("Failed to fetch open tasks.");
        }
    }
}
