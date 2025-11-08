package srp;

import java.time.LocalDateTime;
import java.util.Collection;

public class ReportManager {
    public void generateReport(Collection<Integer> data) {
        System.out.println("=== Report ===");
        int sum = Calculator.calculateSum(data);
        double avg = Calculator.calculateAverage(data);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
        System.out.println("Generated at: " + LocalDateTime.now());

        FileSaver.saveToFile(sum, avg);
    }
}