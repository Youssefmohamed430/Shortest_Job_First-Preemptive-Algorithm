<!DOCTYPE html>
<html lang="en">
<body>
    <div class="header">
        <h1>🚀 Shortest Job First (Preemptive)</h1>
        <p>Advanced Operating System CPU Scheduling Simulator</p>
        <div class="tech-stack">
            <span class="tech-badge">Java Swing</span>
            <span class="tech-badge">Operating Systems</span>
            <span class="tech-badge">Algorithm Visualization</span>
            <span class="tech-badge">GUI Application</span>
        </div>
    </div>
    <div class="section">
        <h2>📋 Project Overview</h2>
        <p>This project implements the <span class="highlight">Shortest Job First (Preemptive)</span> CPU scheduling algorithm using Java Swing GUI. It provides a comprehensive simulation environment for understanding one of the most important scheduling algorithms in operating systems.</p>
        <p>The application demonstrates how the SJF preemptive algorithm works by allowing users to input multiple processes with their arrival times and burst times, then visualizing the scheduling process through interactive tables and Gantt charts.</p>
        <div class="algorithm-box">
            <h4>🧠 Algorithm Concept</h4>
            <p><strong>Shortest Job First (Preemptive)</strong> - also known as Shortest Remaining Time First (SRTF) - is a CPU scheduling algorithm that selects the process with the shortest remaining execution time. When a new process arrives, if its burst time is shorter than the remaining time of the currently executing process, the CPU is preempted and allocated to the new process.</p>
        </div>
    </div>
    <div class="section">
        <h2>✨ Key Features</h2>
        <div class="features-grid">
            <div class="feature-card">
                <h4>🎯 Process Management</h4>
                <p>Add multiple processes with custom arrival times and burst times</p>
            </div>
            <div class="feature-card">
                <h4>📊 Algorithm Simulation</h4>
                <p>Real-time simulation of SJF preemptive scheduling algorithm</p>
            </div>
            <div class="feature-card">
                <h4>📈 Performance Metrics</h4>
                <p>Calculate and display average turnaround, waiting, and response times</p>
            </div>
            <div class="feature-card">
                <h4>📋 Gantt Chart</h4>
                <p>Visual representation of process execution timeline</p>
            </div>
            <div class="feature-card">
                <h4>🖥️ Interactive GUI</h4>
                <p>User-friendly interface built with Java Swing</p>
            </div>
            <div class="feature-card">
                <h4>⚡ Real-time Updates</h4>
                <p>Dynamic updates of scheduling table and statistics</p>
            </div>
        </div>
    </div>
    <div class="section">
        <h2>🔧 How It Works</h2>
        <h3>Algorithm Implementation</h3>
        <p>The SJF Preemptive algorithm follows these steps:</p>
        <ol>
            <li><strong>Process Arrival:</strong> Processes arrive at different times with specified burst times</li>
            <li><strong>Selection Criteria:</strong> At any given time, select the process with the shortest remaining burst time</li>
            <li><strong>Preemption:</strong> If a new process arrives with a shorter burst time than the currently running process, preempt the current process</li>
            <li><strong>Execution:</strong> Execute the selected process for one time unit</li>
            <li><strong>Repeat:</strong> Continue until all processes are completed</li>
        </ol>
        <h3>Performance Calculations</h3>
        <table class="stats-table">
            <tr>
                <th>Metric</th>
                <th>Formula</th>
                <th>Description</th>
            </tr>
            <tr>
                <td><strong>Turnaround Time</strong></td>
                <td>Completion Time - Arrival Time</td>
                <td>Total time from arrival to completion</td>
            </tr>
            <tr>
                <td><strong>Waiting Time</strong></td>
                <td>Turnaround Time - Burst Time</td>
                <td>Time spent waiting in ready queue</td>
            </tr>
            <tr>
                <td><strong>Response Time</strong></td>
                <td>First CPU allocation - Arrival Time</td>
                <td>Time from arrival to first CPU allocation</td>
            </tr>
        </table>
    </div>
    <div class="section">
        <h2>🖼️ Application Screenshots</h2>
        <h3>Main Interface</h3>
        <p>The application features a clean, intuitive interface where users can:</p>
        <ul>
            <li>Input the number of processes</li>
            <li>Enter process details (Process ID, Arrival Time, Burst Time)</li>
            <li>View the scheduling table with all process information</li>
            <li>Execute the algorithm and view results</li>
        </ul>
        <h3>Results Display</h3>
        <p>After running the algorithm, the application displays:</p>
        <ul>
            <li><span class="badge">Average Turnaround Time</span> - Overall efficiency metric</li>
            <li><span class="badge">Average Waiting Time</span> - Queue waiting performance</li>
            <li><span class="badge">Average Response Time</span> - System responsiveness</li>
        </ul>
        <h3>Gantt Chart Visualization</h3>
        <p>The interactive Gantt chart shows:</p>
        <ul>
            <li>Process execution timeline</li>
            <li>Color-coded process identification</li>
            <li>Time scale with precise intervals</li>
            <li>Visual representation of preemption points</li>
        </ul>
    </div>
    <div class="section">
        <h2>🛠️ Technical Implementation</h2>
        <h3>Architecture</h3>
        <p>The project is built using Java Swing and follows object-oriented programming principles:</p>
        <div class="code-block">
public class SJFScheduler {
    private List&lt;Process&gt; processes;
    private List&lt;GanttBlock&gt; ganttChart;
    public void executeScheduling() {
        // Implementation of SJF Preemptive Algorithm
        sortProcessesByArrivalTime();
        simulateScheduling();
        calculateMetrics();
        generateGanttChart();
    }
}
        </div>
        <h3>Key Components</h3>
        <ul>
            <li><strong>Process Class:</strong> Represents individual processes with properties like PID, arrival time, burst time, etc.</li>
            <li><strong>Scheduler Engine:</strong> Core algorithm implementation for SJF preemptive scheduling</li>
            <li><strong>GUI Components:</strong> Swing-based user interface with tables, forms, and charts</li>
            <li><strong>Metrics Calculator:</strong> Computes performance statistics and averages</li>
            <li><strong>Gantt Chart Generator:</strong> Creates visual timeline representation</li>
        </ul>
    </div>
    <div class="section">
        <h2>📦 Installation & Usage</h2>        
        <h3>Prerequisites</h3>
        <ul>
            <li>Java Development Kit (JDK) 8 or higher</li>
            <li>IDE (NetBeans, IntelliJ IDEA, or Eclipse) - Optional</li>
        </ul>
        <h3>Installation Steps</h3>
        <ol class="installation-steps">
            <li>Clone the repository to your local machine</li>
            <li>Open the project in your preferred Java IDE</li>
            <li>Compile the Java source files</li>
            <li>Run the main application class</li>
            <li>The GUI window will open, ready for input</li>
        </ol>
        <h3>How to Use</h3>
        <ol class="installation-steps">
            <li>Enter the number of processes you want to schedule</li>
            <li>Click "Confirm" to generate input fields</li>
            <li>Fill in Process ID, Arrival Time, and Burst Time for each process</li>
            <li>Click "Add Process" to add each process to the scheduling table</li>
            <li>Click "Run Algorithm" to execute the SJF preemptive scheduling</li>
            <li>View the calculated averages and generated Gantt chart</li>
        </ol>
    </div>
    <div class="section">
        <h2>🎯 Learning Objectives</h2>
        <p>This project helps students understand:</p>
        <ul>
            <li><strong>CPU Scheduling Algorithms:</strong> Practical implementation of SJF preemptive scheduling</li>
            <li><strong>Operating System Concepts:</strong> Process management, context switching, and scheduling</li>
            <li><strong>Algorithm Analysis:</strong> Performance metrics and algorithm efficiency</li>
            <li><strong>GUI Programming:</strong> Java Swing components and event handling</li>
            <li><strong>Data Structures:</strong> Lists, queues, and sorting algorithms</li>
            <li><strong>Software Engineering:</strong> Object-oriented design and modular programming</li>
        </ul>
    </div>
    <div class="section">
        <h2>🔍 Algorithm Advantages & Disadvantages</h2>  
        <h3>✅ Advantages</h3>
        <ul>
            <li>Optimal average waiting time for given processes</li>
            <li>Better performance than FCFS for most scenarios</li>
            <li>Suitable for batch processing systems</li>
        </ul>
        <h3>❌ Disadvantages</h3>
        <ul>
            <li>Starvation of longer processes</li>
            <li>Requires knowledge of burst time in advance</li>
            <li>High context switching overhead due to preemption</li>
        </ul>
    </div>
    <div class="section">
        <h2>🚀 Future Enhancements</h2>
        <ul>
            <li>Add support for priority-based scheduling</li>
            <li>Implement process aging to prevent starvation</li>
            <li>Add export functionality for Gantt charts</li>
            <li>Include animation for process execution</li>
            <li>Add comparison with other scheduling algorithms</li>
            <li>Implement multi-level queue scheduling</li>
        </ul>
    </div>
    <div class="section">
        <h2>📚 References & Resources</h2>
        <ul>
            <li>Operating System Concepts by Abraham Silberschatz</li>
            <li>Modern Operating Systems by Andrew Tanenbaum</li>
            <li>CPU Scheduling Algorithms - Academic Papers</li>
            <li>Java Swing Documentation - Oracle</li>
        </ul>
    </div>
    <div class="section">
        <h2>👨‍💻 Contributing</h2>
        <p>Contributions are welcome! Please feel free to submit pull requests or open issues for:</p>
        <ul>
            <li>Bug fixes and improvements</li>
            <li>New features and enhancements</li>
            <li>Documentation updates</li>
            <li>Performance optimizations</li>
        </ul>
    </div>
    <div class="section">
        <h2>📄 License</h2>
        <p>This project is open source and available under the <strong>MIT License</strong>.</p>
        <div style="text-align: center; margin-top: 30px; padding: 20px; background: #f8f9fa; border-radius: 10px;">
            <p><strong>Made with ❤️ for Operating Systems Education</strong></p>
            <p style="font-size: 0.9em; color: #666;">Demonstrating CPU Scheduling Algorithms through Interactive Visualization</p>
        </div>
    </div>
</body>
</html>
