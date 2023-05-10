import java.time.Instant;

public class JavaPi {
    
    //Calculate pi to a given number
    public static double Leibniz(int iterations) {
        double n = 1;
        for (int i = 2; i < iterations; i++) {
            double term = Math.pow(-1, i - 1) / ((2 * i) - 1);
            n += term;
        }
        return n * 4;
    }

    public static double LeibnizTurbo(int iterations) {
        double n = 1;
        double topTerm = -1;
        for (int i = 2; i < iterations; i++) {
            int bottomTerm = i << 1;  //Bitwise x2 whilst i still int
            double term = topTerm / (bottomTerm - 1);
            n += term;
            topTerm = -topTerm;  //Flip sign of top term without exponent
        }
        return n * 4;
    }
    
    public static void main(String[] args) {
        System.out.println("\nStarting Leibniz Approximation");
        Instant start = Instant.now();
        System.out.println(LeibnizTurbo(100000000));
        Instant end = Instant.now();
        
        double elapsed = (end.toEpochMilli() - start.toEpochMilli()) / 1000.0;
        System.out.printf("Elapsed Time: %.4f seconds\n\n", elapsed);
    }
}
