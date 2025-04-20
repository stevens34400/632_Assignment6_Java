package src;

import java.util.*;

public class TaskQueue {
    private final Queue<Task> queue = new LinkedList<>();

    public synchronized void addTask(Task task) {
        queue.offer(task);
        notify();
    }

    public synchronized Task getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.poll();
    }
}
