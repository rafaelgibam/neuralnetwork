public class Run {


    public static void main(String[] args) {

        double[][] inputs = {
                new double[]{1,1},
                new double[]{1,0},
                new double[]{0,1},
                new double[]{0,0},
        };

        double[] desired = {0, 1, 1, 0};

        NeuralNetwork network = new NeuralNetwork(inputs, 1000);
        network.train(desired);
    }
}
