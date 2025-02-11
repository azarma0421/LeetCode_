class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost)
            return -1;

        int sumGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i] - cost[i];
            if (sumGas < 0) {
                sumGas = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
