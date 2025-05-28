//
//import java.util.Scanner;
//
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
///**
// *
// * @author youss
// */
//public class NewClass { 
//    import java.util.Scanner;
//
//class Process {
//    int pid;
//    int arrival;
//    int burst;
//    int remaining;
//    int start;
//    int finish;
//    int completed;
//    int waiting_time;
//    int respone_time;
//    int turnaround_time;
//}
//
//class Main {
//    static final int MAX_PROCESSES = 100;
//
//    static int calculate_respone_times(Process[] p, int n) {
//        for (intultur i = 0; i < n; i++) {
//            p[i].respone_time = p[i].start - p[i].arrival;
//        }
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += p[i].respone_time;
//        }
//        return sum / n;
//    }
//
//    static int calculate_turnaround_times(Process[] p, int n) {
//        for (int i = 0; i < n; i++) {
//            p[i].respone_time = p[i].finish - p[i].arrival;
//        }
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += p[i].turnaround_time;
//        }
//        return sum / n;
//    }
//
//    static int calculate_waiting_times(Process[] p, int n) {
//        for (int i = 0; i < n; i++) {
//            p[i].waiting_time = p[i].finish - p[i].arrival - p[i].burst;
//        }
//        return 0; // ملاحظة: الدالة في الكود الأصلي لا تعيد شيء، لكن يجب إرجاع قيمة في Java
//    }
//
//    static int calculate_average(Process[] p, int n) {
//        int sum = 0, counter = 0;
//        for (int i = 0; i < n; i++) {
//            sum += p[i].waiting_time;
//            counter++;
//        }
//        return sum / counter;
//    }
//
//    public static void SJFAlgo(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n;
//        Process[] p = new Process[MAX_PROCESSES];
//        int total_completed = 0;
//        int current_time = 0;
//        int min_remaining_time;
//        int shortest;
//
//        do {
//            System.out.print("Enter the number of processes (1-100): ");
//            n = scanner.nextInt();
//        } while (n <= 0 || n > MAX_PROCESSES);
//
//        for (int i = 0; i < n; i++) {
//            p[i] = new Process();
//            p[i].pid = i + 1;
//            do {
//                System.out.print("Enter arrival time for Process " + (i + 1) + ": ");
//                p[i].arrival = scanner.nextInt();
//            } while (p[i].arrival < 0);
//
//            do {
//                System.out.print("Enter burst time for Process " + (i + 1) + ": ");
//                p[i].burst = scanner.nextInt();
//            } while (p[i].burst <= 0);
//
//            p[i].remaining = p[i].burst;
//            p[i].completed = 0;
//            p[i].start = -1;
//        }
//
//        while (total_completed < n) {
//            min_remaining_time = Integer.MAX_VALUE;
//            shortest = -1;
//            for (int i = 0; i < n; i++) {
//                if (p[i].arrival <= current_time && p[i].completed == 0 && p[i].remaining < min_remaining_time) {
//                    min_remaining_time = p[i].remaining;
//                    shortest = i;
//                }
//            }
//
//            if (shortest == -1) {
//                current_time++;
//                continue;
//            }
//
//            if (p[shortest].start == -1) {
//                p[shortest].start = current_time;
//            }
//
//            p[shortest].remaining--;
//            current_time++;
//
//            if (p[shortest].remaining == 0) {
//                p[shortest].completed = 1;
//                p[shortest].finish = current_time;
//                total_completed++;
//            }
//        }
//    }
//}
//    
//}
