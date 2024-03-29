import java.util.Random;

public class DoublingHypothesis {

    public static void main(String[] args) {
        // Array of input sizes (N)
        int[] inputSizes = {1000, 2000, 4000, 8000000, 16000}; // Tamanhos de entrada (N)
        
        // Print header for output
        System.out.println("N\tTempo de Execução (ms)");
        
        // Iterate over each input size
        for (int N : inputSizes) {
            // Run experiment and get elapsed time
            long elapsedTime = runExperiment(N);
            // Print input size and elapsed time
            System.out.println(N + "\t" + elapsedTime);
        }
    }
    
    // Method to run the experiment with a given input size (N)
    private static long runExperiment(int N) {
        // Initialize QuickUnionUF with input size N
        QuickUnionUF uf = new QuickUnionUF(N);
        // Record start time
        long startTime = System.currentTimeMillis();
        // Perform random unions
        performRandomUnions(uf, N);
        // Record end time
        long endTime = System.currentTimeMillis();
        // Calculate elapsed time
        long elapsedTime = endTime - startTime;
        // Return elapsed time
        return elapsedTime;
    }
    
    // Method to perform random unions with a given QuickUnionUF instance and input size (N)
    private static void performRandomUnions(QuickUnionUF uf, int N) {
        // Initialize Random object
        Random random = new Random();
        // Iterate N times to perform unions
        for (int i = 0; i < N; i++) {
            // Generate random points
            int p = random.nextInt(N);
            int q = random.nextInt(N);
            // Perform union
            uf.union(p, q);
        }
    }
}
