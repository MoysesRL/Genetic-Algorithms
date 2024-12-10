public class Main {
    public static void main(String[] args) {

        float[] x = {1, 2, 3, 4};  // Variable independiente
        float[] y = {2, 4, 6, 8};  // Variable dependiente

        Individual best = GeneticAlgorithm.evolve(x, y);

        System.out.println("Mejor b0: " + best.b0);
        System.out.println("Mejor b1: " + best.b1);
    }
}
