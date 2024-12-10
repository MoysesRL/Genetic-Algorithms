import java.util.Random;

public class GeneticAlgorithm {
    private static final int TAMAÑO_POBLACION = 20;
    private static final int NUM_GENERACIONES = 100;
    private static final float TASA_MUTACION = 0.1f;

    private static Random rand = new Random();

    public static Individual crossover(Individual p1, Individual p2) {
        Individual child = new Individual();
        child.b0 = (p1.b0 + p2.b0) / 2;
        child.b1 = (p1.b1 + p2.b1) / 2;
        return child;
    }

    public static void mutate(Individual individual) {
        if (rand.nextFloat() < TASA_MUTACION) {
            individual.b0 += rand.nextFloat() * 2 - 1; // Mutar b0
        }
        if (rand.nextFloat() < TASA_MUTACION) {
            individual.b1 += rand.nextFloat() * 2 - 1; // Mutar b1
        }
    }

    public static Individual evolve(float[] x, float[] y) {
        Individual[] population = new Individual[TAMAÑO_POBLACION];
        for (int i = 0; i < TAMAÑO_POBLACION; i++) {
            population[i] = new Individual();
        }

        Individual best = population[0];

        for (int generation = 0; generation < NUM_GENERACIONES; generation++) {
            for (Individual ind : population) {
                ind.calcularFitness(x, y);
            }

            for (Individual ind : population) {
                if (ind.fitness > best.fitness) {
                    best = ind;
                }
            }

            Individual[] newPopulation = new Individual[TAMAÑO_POBLACION];
            for (int i = 0; i < TAMAÑO_POBLACION; i++) {
                Individual parent1 = population[rand.nextInt(TAMAÑO_POBLACION)];
                Individual parent2 = population[rand.nextInt(TAMAÑO_POBLACION)];
                Individual child = crossover(parent1, parent2);
                mutate(child);
                newPopulation[i] = child;
            }
            population = newPopulation;

            System.out.println("Generación " + generation + " Mejor MSE: " + (-best.fitness));
        }

        return best;
    }
}
