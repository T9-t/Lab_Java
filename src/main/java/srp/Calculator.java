package srp;

import java.util.Collection;

public class Calculator {
    public static int calculateSum(Collection<Integer> data) {
        int sum = 0;
        for (int n : data) {
            sum += n;
        }
        return sum;
    }
    public static double calculateAverage(Collection<Integer> data) {
        if (data.isEmpty()) return 0;
        return (double) calculateSum(data) / data.size();
    }
}
