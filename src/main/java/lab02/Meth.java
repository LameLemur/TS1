package lab02;

public class Meth {
    public int factorial(int n) {
        return n > 1 ? factorial(n - 1) * n : 1;
    }

    public int newFactorial(int n) {
        return n > 1 ? factorial(n - 1) * n : 1;
    }
}
