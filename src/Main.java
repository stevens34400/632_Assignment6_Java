package src;

import java.util.concurrent.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a task queue to hold tasks
        TaskQueue queue = new TaskQueue();
        
        // Create a result writer to write results to a file
        ResultWriter writer = new ResultWriter("output/results.txt");

        // Populate the task queue with dummy tasks
        for (int i = 1; i <= 20; i++) {
            queue.addTask(new Task("Task-" + i));
        }

        // Define the number of worker threads
        int numberOfWorkers = 4;
        
        // Create a fixed thread pool with the specified number of workers
        ExecutorService executor = Executors.newFixedThreadPool(numberOfWorkers);

        // Submit worker tasks to the executor
        for (int i = 0; i < numberOfWorkers; i++) {
            executor.submit(new Worker(queue, writer, "Worker-" + (i + 1)));
        }

        // Shutdown the executor service
        executor.shutdown();
        try {
            // Wait for all tasks to complete or timeout after 1 minute
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            // Handle the exception if the waiting is interrupted
            e.printStackTrace();
        }

        // Print a message indicating all tasks are completed
        System.out.println("All tasks completed.");
    }
}