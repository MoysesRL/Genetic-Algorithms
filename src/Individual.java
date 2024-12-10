import java.util.Random;

public class Individual {
    public float b0;
    public float b1;
    public float fitness;

    private static Random rand = new Random();

    public Individual() {
        this.b0 = rand.nextFloat() * 10 - 5;
        this.b1 = rand.nextFloat() * 10 - 5;
    }

    public float calcularFitness(float[] x, float[] y) {
        float mse = 0;
        for (int i = 0; i < x.length; i++) {
            float predicted = b0 + b1 * x[i];
            mse += Math.pow(predicted - y[i], 2);
        }
        this.fitness = -mse / x.length; // Minimizar MSE
        return this.fitness;
    }
}
