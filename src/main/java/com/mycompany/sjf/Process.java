/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sjf;

/**
 *
 * @author youss
 */
public class Process {
    public int pid;
    public int arrival;
    public int burst;
    public int remaining;
    public int start;
    public int finish;
    public int completed;
    public int waiting_time;
    public int respone_time;
    public int turnaround_time;
    
    public Process() {
        this.pid = 0;
        this.arrival = 0;
        this.burst = 0;
        this.remaining = 0;
        this.finish = 0;
        this.turnaround_time = 0;
        this.waiting_time = 0;
        this.respone_time = 0;
        this.completed = 0;
        this.start = -1;
    }
    
    /**
     * Constructor for Process class with specified parameters
     * 
     * @param pid Process ID
     * @param arrival Arrival time
     * @param burst Burst time
     */
    public Process(int pid, int arrival, int burst) {
        this.pid = pid;
        this.arrival = arrival;
        this.burst = burst;
        this.remaining = burst;
        this.finish = 0;
        this.turnaround_time = 0;
        this.waiting_time = 0;
        this.respone_time = 0;
        this.completed = 0;
        this.start = -1;
    }
}
