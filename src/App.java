import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter the number of Processor: ");
        try (Scanner sc = new Scanner(System.in)) {
            int process = sc.nextInt();

            int process_id[] = new int[process];
            int burst_time[] = new int[process];
            int arrival_time[] = new int[process];
            int waiting_time[] = new int[process];
            int turnaround_time[] = new int[process];
            int completion_time[] = new int[process];

            for (int i = 0; i < process; i++) {

                System.out.print("Enter the arrival time of process " + (i + 1) + ":");
                arrival_time[i] = sc.nextInt();
                System.out.print("Enter the burst time of process " + (i + 1) + ":");
                burst_time[i] = sc.nextInt();
                process_id[i] = i + 1;
            }

            int temp;
            for (int i = 0; i < process; i++) {
                for (int j = i + 1; j < process; j++) {
                    if (arrival_time[i] > arrival_time[j]) {
                        temp = arrival_time[i];
                        arrival_time[i] = arrival_time[j];
                        arrival_time[j] = temp;

                        temp = process_id[i];
                        process_id[i] = process_id[j];
                        process_id[j] = temp;
                        temp = burst_time[i];
                        burst_time[i] = burst_time[j];
                        burst_time[j] = temp;
                    }
                }
            }
            System.out.println();
            completion_time[0] = burst_time[0] - arrival_time[0];
            for (int i = 1; i < process; i++) {
                completion_time[i] = completion_time[i - 1] + burst_time[i];
            }
            for (int i = 0; i < process; i++) {
                turnaround_time[i] = completion_time[i] - arrival_time[i];
            }
            for (int i = 0; i < process; i++) {
                waiting_time[i] = turnaround_time[i] - burst_time[i];
            }

            System.out.println(
                    "Process id\t Arival time\t Brust time \t Completion time \t turnaround time  \t waiting time");
            for (int i = 0; i < process; i++) {
                System.out.println("P" + process_id[i] + "\t\t" + arrival_time[i] + "\t\t" + burst_time[i] + "\t\t"
                        + completion_time[i] + "\t\t\t" + turnaround_time[i] + "\t\t\t" + waiting_time[i]);
            }

            System.out.println("Gannt Chart");
            for (int i = 0; i < process; i++) {
                System.out.print("P" + process_id[i] + "\t");
            }
            System.out.println();
            System.out.print("0\t");
            for (int i = 0; i < process; i++) {
                
                System.out.print(completion_time[i]+ "\t");
            }
        }
    }
}
