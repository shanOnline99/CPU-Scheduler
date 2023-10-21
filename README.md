# CPU-Scheduler
CPU scheduler using Java
This repository contains a CPU scheduling application implemented in Java that explores four different scheduling algorithms: First Come First Serve (FCFS), Shortest Remaining Time (SRT), Shortest Job First (SJF), and Round Robin (RR). These algorithms are fundamental to the efficient utilization of CPU resources in operating systems and are widely used in task and process management.
# Overview
## Algorithms Implemented
- First Come First Serve (FCFS): This algorithm schedules processes in the order they arrive, providing a simple but not always optimal approach.
- Shortest Remaining Time (SRT): A preemptive variation of SJF, it selects the process with the shortest remaining execution time.
- Shortest Job First (SJF): This non-preemptive algorithm selects the process with the shortest burst time, minimizing waiting times.
- Round Robin (RR): A time-sharing algorithm that allocates a fixed time slice to each process in a circular manner.
# Performance Metrics
The application calculates and compares the average waiting time and average turnaround time for each of the implemented algorithms. The results are displayed, providing insights into the efficiency of each scheduling method.
# Getting Started
- Clone this repository to your local machine.
- Navigate to the project directory.
- Compile the Java source code using your preferred Java compiler.
- Run the application and input your task/process data.
- Analyze the output for average waiting time and average turnaround time.
# Contributing
Contributions are welcome! If you'd like to enhance the project or fix issues, please fork the repository and create a pull request.

# Contact
For any questions or feedback, please open an issue on this repository.

