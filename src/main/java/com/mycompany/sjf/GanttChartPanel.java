/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sjf;

/**
 *
 * @author youss
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * GanttChartPanel displays a visual representation of process execution timing
 * for Shortest Job First (Preemptive) scheduling algorithm
 */
public class GanttChartPanel extends JPanel {
    
    private ArrayList<TimeSlot> timeSlots;
    private int maxTime;
    private int numProcesses;
    private Map<Integer, Color> processColors;
    
    // Constants for chart drawing
    private static final int CHART_HEIGHT = 300;
    private static final int TIME_UNIT_WIDTH = 30;
    private static final int PROCESS_HEIGHT = 40;
    private static final int MARGIN_TOP = 50;
    private static final int MARGIN_LEFT = 50;
    private static final int MARGIN_RIGHT = 50;
    private static final int MARGIN_BOTTOM = 50;
    
    /**
     * TimeSlot represents a single unit of time in the Gantt chart
     */
    static class TimeSlot {
        int processId; // -1 means idle
        int startTime;
        int endTime;
        
        public TimeSlot(int processId, int startTime, int endTime) {
            this.processId = processId;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    
    /**
     * Constructor for GanttChartPanel
     * @param processList The list of processes scheduled with SJF algorithm
     */
    public GanttChartPanel(ArrayList<Process> processList) {
        numProcesses = processList.size();
        generateTimeSlots(processList);
        initializeColors();
        
        int width = MARGIN_LEFT + (maxTime * TIME_UNIT_WIDTH) + MARGIN_RIGHT;
        int height = CHART_HEIGHT;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
    }
    
    /**
     * Initialize colors for each process
     */
    private void initializeColors() {
        processColors = new HashMap<>();
        
        // Generate distinct colors for each process
        Color[] colorPalette = {
            new Color(70, 130, 180),   // Steel Blue
            new Color(255, 99, 71),    // Tomato
            new Color(50, 205, 50),    // Lime Green
            new Color(255, 165, 0),    // Orange
            new Color(186, 85, 211),   // Medium Purple
            new Color(30, 144, 255),   // Dodger Blue
            new Color(220, 20, 60),    // Crimson
            new Color(46, 139, 87),    // Sea Green
            new Color(255, 215, 0),    // Gold
            new Color(148, 0, 211)     // Dark Violet
        };
        
        for (int i = 0; i < numProcesses; i++) {
            int colorIndex = i % colorPalette.length;
            processColors.put(i + 1, colorPalette[colorIndex]);
        }
        
        // Color for idle time
        processColors.put(-1, Color.LIGHT_GRAY);
    }
    
    /**
     * Generate time slots from the process execution data
     * @param processList List of processes with execution information
     */
    private void generateTimeSlots(ArrayList<Process> processList) {
        timeSlots = new ArrayList<>();
        maxTime = 0;
        
        // Create a timeline array to track which process is running at each time unit
        int lastFinishTime = 0;
        for (Process p : processList) {
            if (p.finish > lastFinishTime) {
                lastFinishTime = p.finish;
            }
        }
        
        int[] timeline = new int[lastFinishTime + 1];
        for (int i = 0; i < timeline.length; i++) {
            timeline[i] = -1; // -1 means idle
        }
        
        // Simulate SJF preemptive execution to populate the timeline
        simulateSJFExecution(processList, timeline);
        
        // Convert timeline to time slots (consolidate consecutive time units with same process)
        int currentProcess = timeline[0];
        int startTime = 0;
        
        for (int t = 1; t < timeline.length; t++) {
            if (timeline[t] != currentProcess) {
                timeSlots.add(new TimeSlot(currentProcess, startTime, t));
                currentProcess = timeline[t];
                startTime = t;
            }
        }
        
        // Add the last time slot
        if (startTime < timeline.length - 1) {
            timeSlots.add(new TimeSlot(currentProcess, startTime, timeline.length - 1));
        }
        
        maxTime = timeline.length - 1;
    }
    
    /**
     * Simulate SJF preemptive execution to determine which process runs at each time unit
     * @param processList List of processes
     * @param timeline Array to track process execution
     */
    private void simulateSJFExecution(ArrayList<Process> processList, int[] timeline) {
        ArrayList<Process> tempProcessList = new ArrayList<>();
        for (Process p : processList) {
            Process temp = new Process();
            temp.pid = p.pid;
            temp.arrival = p.arrival;
            temp.burst = p.burst;
            temp.remaining = p.burst;
            temp.completed = 0;
            temp.start = -1;
            tempProcessList.add(temp);
        }
        
        int currentTime = 0;
        int totalCompleted = 0;
        
        while (totalCompleted < tempProcessList.size()) {
            int shortest = -1;
            int minRemainingTime = Integer.MAX_VALUE;
            
            // Find the process with shortest remaining time
            for (int i = 0; i < tempProcessList.size(); i++) {
                Process p = tempProcessList.get(i);
                if (p.arrival <= currentTime && p.completed == 0 && p.remaining < minRemainingTime) {
                    minRemainingTime = p.remaining;
                    shortest = i;
                }
            }
            
            if (shortest == -1) {
                // No process available, CPU idle
                timeline[currentTime] = -1;
                currentTime++;
                continue;
            }
            
            // Assign this time unit to the selected process
            timeline[currentTime] = tempProcessList.get(shortest).pid;
            
            // Update process remaining time
            tempProcessList.get(shortest).remaining--;
            
            // Check if process is completed
            if (tempProcessList.get(shortest).remaining == 0) {
                tempProcessList.get(shortest).completed = 1;
                totalCompleted++;
            }
            
            currentTime++;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Draw chart title
        g2d.setFont(new Font("SansSerif", Font.BOLD, 16));
        g2d.drawString("SJF (Preemptive) Gantt Chart", getWidth() / 2 - 120, 30);
        
        // Draw time slots
        drawTimeSlots(g2d);
        
        // Draw time scale
        drawTimeScale(g2d);
        
        // Draw legend
        drawLegend(g2d);
    }
    
    /**
     * Draw the time slots for each process
     * @param g2d Graphics context
     */
    private void drawTimeSlots(Graphics2D g2d) {
        int y = MARGIN_TOP;
        
        for (TimeSlot slot : timeSlots) {
            int x = MARGIN_LEFT + (slot.startTime * TIME_UNIT_WIDTH);
            int width = (slot.endTime - slot.startTime) * TIME_UNIT_WIDTH;
            
            // Draw the time slot box
            g2d.setColor(processColors.get(slot.processId));
            g2d.fillRect(x, y, width, PROCESS_HEIGHT);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x, y, width, PROCESS_HEIGHT);
            
            // Draw the process ID text
            g2d.setFont(new Font("SansSerif", Font.BOLD, 12));
            String text = slot.processId == -1 ? "IDLE" : "P" + slot.processId;
            int textWidth = g2d.getFontMetrics().stringWidth(text);
            
            // Only draw text if it fits in the time slot
            if (width > textWidth + 4) {
                g2d.drawString(text, x + (width / 2) - (textWidth / 2), y + PROCESS_HEIGHT / 2 + 5);
            }
            
            // Draw the time values at the bottom of the slot
            g2d.setFont(new Font("SansSerif", Font.PLAIN, 10));
            g2d.drawString(Integer.toString(slot.startTime), x, y + PROCESS_HEIGHT + 15);
            
            // Draw the end time for the last slot
            if (slot.endTime == maxTime) {
                g2d.drawString(Integer.toString(slot.endTime), x + width, y + PROCESS_HEIGHT + 15);
            }
        }
    }
    
    /**
     * Draw the time scale
     * @param g2d Graphics context
     */
    private void drawTimeScale(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        int y = MARGIN_TOP + PROCESS_HEIGHT + 30;
        
        // Draw time scale line
        g2d.drawLine(MARGIN_LEFT, y, MARGIN_LEFT + (maxTime * TIME_UNIT_WIDTH), y);
        
        // Draw time scale ticks and labels
        for (int t = 0; t <= maxTime; t++) {
            int x = MARGIN_LEFT + (t * TIME_UNIT_WIDTH);
            g2d.drawLine(x, y - 3, x, y + 3);
            g2d.drawString(Integer.toString(t), x - 3, y + 20);
        }
    }
    
    /**
     * Draw the legend for process colors
     * @param g2d Graphics context
     */
    private void drawLegend(Graphics2D g2d) {
        int legendX = MARGIN_LEFT;
        int legendY = MARGIN_TOP + PROCESS_HEIGHT + 60;
        int entryWidth = 100;
        int entryHeight = 20;
        int colorBoxSize = 15;
        
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        for (int pid = 1; pid <= numProcesses; pid++) {
            // Draw color box
            g2d.setColor(processColors.get(pid));
            g2d.fillRect(legendX, legendY, colorBoxSize, colorBoxSize);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(legendX, legendY, colorBoxSize, colorBoxSize);
            
            // Draw process label
            g2d.drawString("Process " + pid, legendX + colorBoxSize + 5, legendY + colorBoxSize - 3);
            
            // Move to next position (either right or new row)
            if (pid % 3 == 0) {
                legendX = MARGIN_LEFT;
                legendY += entryHeight + 5;
            } else {
                legendX += entryWidth;
            }
        }
        
        // Add idle time to legend if needed
        boolean hasIdle = false;
        for (TimeSlot slot : timeSlots) {
            if (slot.processId == -1) {
                hasIdle = true;
                break;
            }
        }
        
        if (hasIdle) {
            if ((numProcesses % 3 == 0)) {
                legendX = MARGIN_LEFT;
                legendY += entryHeight + 5;
            }
            
            g2d.setColor(processColors.get(-1));
            g2d.fillRect(legendX, legendY, colorBoxSize, colorBoxSize);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(legendX, legendY, colorBoxSize, colorBoxSize);
            g2d.drawString("IDLE", legendX + colorBoxSize + 5, legendY + colorBoxSize - 3);
        }
    }
    
    /**
     * Create and display the Gantt chart in a new window
     * @param processList List of processes with execution information
     */
    public static void showGanttChart(ArrayList<Process> processList) {
        JFrame frame = new JFrame("SJF Preemptive Gantt Chart");
        GanttChartPanel chart = new GanttChartPanel(processList);
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(chart);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
