public class TernaryALU {
    public int ternaryAdd(int a, int b) {
        int sum = a + b;
        if (sum > 1) return 1;
        if (sum < -1) return -1;
        return sum;
    }
}
