package src;

public class Task {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String process() throws InterruptedException {
        Thread.sleep(500); // simulate processing delay
        return name + " processed by " + Thread.currentThread().getName();
    }
}