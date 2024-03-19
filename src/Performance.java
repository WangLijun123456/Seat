import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Performance {
    private String performanceID;
    private String performanceName;
    private String performanceLeadName;

    public Performance(String performanceID, String performanceName, String performanceLeadName) {
        this.performanceID = performanceID;
        this.performanceName = performanceName;
        this.performanceLeadName = performanceLeadName;
    }

    public void setPerformanceID(String performanceID) {
        this.performanceID = performanceID;
    }

    public String getPerformanceID() {
        return performanceID;
    }

    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public void setPerformanceLeadName(String performanceLeadName) {
        this.performanceLeadName = performanceLeadName;
    }

    public String getPerformanceLeadName() {
        return performanceLeadName;
    }

    public String toString() {
        return "Performance{" +
                "performanceID='" + performanceID + '\'' +
                ", performanceName='" + performanceName + '\'' +
                ", performanceLeadName='" + performanceLeadName + '\'' +
                '}';
    }
}

class HandlePerformances {
    private Queue<Performance> performances;

    public HandlePerformances() {
        this.performances = new LinkedList<>();
    }

    public void handlePerformances() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Options:");
            System.out.println("1. Add performances");
            System.out.println("2. Display all the performances");
            System.out.println("3. Start the performance");
            System.out.println("4. QUIT");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("How many performances must be added: ");
                    int numPerformances = scanner.nextInt();
                    scanner.nextLine(); 
                    for (int i = 0; i < numPerformances; i++) {
                        addPerformance(scanner);
                    }
                    break;
                case 2:
                    displayPerformances();
                    break;
                case 3:
                    startPerformance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } while (choice != 4);
    }

    private void addPerformance(Scanner scanner) {
        System.out.print("Enter performance ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter performance name: ");
        String name = scanner.nextLine();
        System.out.print("Enter lead name: ");
        String leadName = scanner.nextLine();

        Performance performance = new Performance(id, name, leadName);
        performances.add(performance);
    }

    private void displayPerformances() {
        System.out.println("Performances:");
        for (Performance performance : performances) {
            System.out.println(performance);
        }
    }

    private void startPerformance() {
        if (!performances.isEmpty()) {
            System.out.println("Starting performance:");
            System.out.println(performances.peek());
        } else {
            System.out.println("No performances available.");
        }
    }
}

/*public class Main {
    public static void main(String[] args) {
        HandlePerformances handlePerformances = new HandlePerformances();
        handlePerformances.handlePerformances();
    }
}
*/
