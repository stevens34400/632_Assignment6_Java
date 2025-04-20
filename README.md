# 632_Assignment6_Java

## Project Overview

This project is a multithreaded Java application that processes tasks using a pool of worker threads. The application demonstrates the use of Java's concurrency utilities to manage task execution and result writing in a thread-safe manner.

## Project Structure

- **src/Main.java**: The entry point of the application. It initializes the task queue, result writer, and worker threads.
- **src/Worker.java**: Implements the `Runnable` interface to allow execution in a separate thread. It fetches tasks from the queue, processes them, and writes the results.
- **src/TaskQueue.java**: A synchronized queue that holds tasks to be processed by workers.
- **src/Task.java**: Represents a task with a name and a method to process it.
- **src/ResultWriter.java**: Responsible for writing the results of processed tasks to a file in a thread-safe manner.

## How to Run

1. **Compile the Project**: Ensure you have Java installed on your system. Navigate to the `src` directory and compile the Java files:
   ```bash
   javac *.java
   ```

2. **Run the Application**: Execute the `Main` class to start the application:
   ```bash
   java Main
   ```

3. **Output**: The results of the processed tasks will be written to `output/results.txt`. Ensure the `output` directory exists or create it before running the application.

## Features

- **Multithreading**: Utilizes a fixed thread pool to manage worker threads.
- **Task Processing**: Simulates task processing with a delay.
- **Result Writing**: Writes results to a file in a thread-safe manner.

## Dependencies

- Java Development Kit (JDK) 8 or higher.

## Notes

- Ensure that the `output` directory exists in the project root to avoid file writing errors.
- The application processes 20 tasks using 4 worker threads by default. You can modify these values in `Main.java`.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
