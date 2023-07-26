import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = numbers.stream()         // Create a stream from the list
                        .filter(n -> n % 2 == 0) // Filter even numbers
                        .mapToInt(n -> n)       // Map Integer objects to int values
                        .sum();                 // Calculate the sum of elements

        System.out.println("Sum of even numbers: " + sum);
    }
}
