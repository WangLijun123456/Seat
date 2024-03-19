import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HandlePerformances {
     Queue<Performance> performances = new LinkedList<>();
     Scanner reader = new Scanner(System.in);

     public void handlePerformances() {
        int choice = 0;
        do {
            System.out.println("Options:");
            System.out.println("1. Add performances");
            System.out.println("2. Display all the performances");
            System.out.println("3. Start the performance");
            System.out.println("4. QUIT");

            choice = reader.nextInt();
            reader.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("How many performances must be added: ");
                    int num=reader.nextInt();
                    reader.nextLine();
                    addPerformances(num);
                    break;
                case 2:
                    displayPerformances();
                    break;
                case 3:
                    startPerformances();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } while (choice != 4);
    }

    private void addPerformances(int num) {
        System.out.print("Enter performance ID: ");
        String id = reader.nextLine();
        System.out.print("Enter performance name: ");
        String name = reader.nextLine();
        System.out.print("Enter lead name: ");
        String leadName = reader.nextLine();
        System.out.print("Enter performance group: ");
        char group = reader.nextLine().charAt(0);
        
        Performance performance = new Performance(id, name, leadName, group);
        this.performances.offer(performance);
    }

    private void displayPerformances() {
        System.out.println("Here is the list of performances: " + "\n" + performances);
    }

    private void startPerformances() {
            System.out.println("The next performance starting is: " + performances.poll());
        }
    }



