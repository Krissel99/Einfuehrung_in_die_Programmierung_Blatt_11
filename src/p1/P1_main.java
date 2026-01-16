package p1;

public class P1_main {
    public static void main(String[] args) {

        System.out.println(potIt(2.4, 5));
        System.out.println(potRek(2.4, 5));
    }

    public static double potRek(double basis, int potenz) {
        if (potenz == 0) {
            return 1;
        }
        return basis*potRek(basis, potenz-1);
    }

    public static double potIt(double basis, int potenz) {
        if (potenz == 0) {
            return 1.0;
        }
        double b = basis;
        for (int i = 1; i < potenz; i++) {
            basis *= b;
        }
        return basis;

    }
}