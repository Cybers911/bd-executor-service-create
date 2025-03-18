

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationManager {

    /**
     * Method called to send notifications out.
     * @param tasks List of NotificationTasks tasks to be run
     */
    public void sendSaleNotificationsOut(List<NotificationTask> tasks) {


        // Your implementation here
        /*ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (NotificationTask task : tasks) {
            executorService.submit(task);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println("All tasks completed.");

        try {
        // Code to handle exceptions
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }*/
        // Using Java 8 Streams for parallel execution
        tasks.parallelStream().forEach(task -> task.run());
        // Using Java 8 CompletableFuture for asynchronous execution
        // CompletableFuture<Void> future = tasks.stream().map(CompletableFuture::runAsync).collect(Collectors.toList()).stream().reduce((a, b) -> a.thenAccept(b));
        // future.join(); // Wait for all tasks to complete
        // Using Java 8 CompletableFuture for exception handling
        // future.exceptionally(e -> {
        //     System.err.println("An error occurred: " + e.getMessage());
        //     return null;
        // });
        // Using Java 8 CompletableFuture for cancellation
        // future.cancel(true); // Cancel all tasks
        // Using Java 8 CompletableFuture for combining results
        // CompletableFuture<Void> future = tasks.stream().map(CompletableFuture::runAsync).collect(Collectors.toList()).stream().reduce((a, b) -> a.thenAccept(b));
        // future.join(); // Wait for all tasks to complete
        // Using Java 8 CompletableFuture for exception handling
        // future.exceptionally(e -> {
        //     System.err.println("An error occurred: " + e.getMessage());
        //     return null;
        // });
        // Using Java 8 CompletableFuture for cancellation
        // future.cancel(true); // Cancel all tasks
        // Using Java 8 CompletableFuture for combining results
        // Implementing a custom ExecutorService for demonstration purposes
  /*      ExecutorService executorService = Executors.newFixedThreadPool(3);
        tasks.stream().forEach(task -> executorService.submit(task));
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println("All tasks completed.");
*/
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        tasks.stream().forEach(task -> executorService.submit(task));
        executorService.shutdown();
        while (!executorService.isTerminated()) {

            try {
                Thread.sleep(1000);
                System.out.println("Still waiting for tasks to complete");
                // Code to handle exceptions
            } catch ( InterruptedException e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
            }
        }



    }


