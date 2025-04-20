package src;

// Worker class implements Runnable to allow execution in a separate thread
public class Worker implements Runnable {
    private final TaskQueue queue; // Queue from which tasks are fetched
    private final ResultWriter writer; // Writer to output the results of processed tasks
    private final String workerName; // Name of the worker for identification

    // Constructor to initialize the Worker with a task queue, result writer, and a name
    public Worker(TaskQueue queue, ResultWriter writer, String workerName) {
        this.queue = queue;
        this.writer = writer;
        this.workerName = workerName;
    }

    // The run method is the entry point for the thread
    @Override
    public void run() {
        try {
            // Continuously fetch and process tasks
            while (true) {
                Task task = queue.getTask(); // Get a task from the queue
                String result = task.process(); // Process the task and get the result
                writer.writeResult(result); // Write the result using the writer
                System.out.println(workerName + " completed: " + result); // Log completion
            }
        } catch (InterruptedException e) {
            // Handle interruption of the worker thread
            System.err.println(workerName + " interrupted.");
        } catch (Exception e) {
            // Handle any other exceptions that occur during task processing
            System.err.println(workerName + " encountered error: " + e.getMessage());
        }
    }
}