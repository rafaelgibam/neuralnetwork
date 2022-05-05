public class NeuralNetwork {
    private double[] weights;
    private double bias;

    private double[][] trainingSets;
    private int iterations;

    public NeuralNetwork(double[][] trainingSets, int interations) {
        this.trainingSets = trainingSets;
        this.iterations = interations;
        System.out.println(trainingSets[0].length);
        this.weights = new double[trainingSets[0].length];
        initWeights();
    }

    private void initWeights() {
        for(int i = 0; i < this.weights.length; i++) {
            this.weights[i] = Math.random();
            System.out.println("w: " + this.weights[i]);
        }

        this.bias = Math.random();
        System.out.println("b: " + this.bias);
    }

    public double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public double run(double[] inputs) {
        double sum = 0.0;
        for(int i = 0; i < this.weights.length; i++) {
            sum += (inputs[i] * this.weights[i]);
        }
        sum += this.bias;
        return sigmoid(sum);
    }

    public boolean train(double[] desired) {
        int count = 0;

        do {
            for(int i = 0; i< this.trainingSets.length; i++) {
                double y = this.run(this.trainingSets[i]);
                // Correção de Pesos
                for(int j = 0; j < this.weights.length; j++) {
                    this.weights[j] += (y - desired[i]) * this.trainingSets[i][j];
                }
                this.bias += (y - desired[i]);

                System.out.printf("y: %.10f -> desired: %.10f\n", this.run(this.trainingSets[i]), desired[i]);
            }
            count++;
        } while (count < iterations);

        return true;
    }

}
