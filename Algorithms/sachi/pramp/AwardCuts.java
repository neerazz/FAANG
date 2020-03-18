import java.util.Arrays;

class AwardCuts {

    static double findGrantsCap(double[] grantsArray, double newBudget) {
        if (grantsArray.length == 0) return 0.0;

        Arrays.sort(grantsArray);

        double[] prefixSums = new double[grantsArray.length];
        prefixSums[0] = grantsArray[0];
        for (int i = 1; i < grantsArray.length; i++) {
            prefixSums[i] = prefixSums[i] + prefixSums[i - 1];
        }

        for (int i = grantsArray.length - 1; i >= 1; i--) {
            int traversed = grantsArray.length - i;
            if (traversed * grantsArray[i - 1] + prefixSums[i - 1] < newBudget) {
                return (newBudget - prefixSums[i - 1]) / traversed;
            }
        }

        return newBudget / grantsArray.length;
    }

    public static void main(String[] args) {
        //findGrantsCap(new double[])
    }
}