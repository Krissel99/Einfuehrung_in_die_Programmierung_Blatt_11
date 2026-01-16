package h2;

import java.util.Arrays;

public class H2_main {

    public static long[] cache = new long[1000];

    public static void main(String[] args) {
        benchmark(40);
    }


    public static long fibonacci(int n) {
        if (n == 0) {
            return 0L;
        }
        if (n == 1 || n == 2) {
            return 1L;
        }
        return fibonacci(n-1)+fibonacci(n-2);

    }

    public static long fibonacciCached(int n) {
        if (n == 0) {
            return 0L;
        }
        if (n == 1 || n == 2) {
            return 1L;
        }

        if (n < cache.length && cache[n] != -1) {
            return cache[n];
        }
        long result = fibonacciCached(n-1)+fibonacciCached(n-2);
        cache[n] = result;
        return result;
    }


    public static long fibonacciIt(int n) {
        long n1 = 0L;
        long n2 = 1L;
        long f;
        for (int i = 0; i < n; i++) {
            f  = n2+n1;
            n1 = n2;
            n2 = f;
        }
        return n1;
    }

    public static void benchmark(int n) {
        long start;
        long end;
        long f1, f2, f3;
        long t1, t2, t3;
        emptycache();

        start = System.nanoTime();
        f1    = fibonacci(n);
        end   = System.nanoTime();
        t1    = end-start;

        start = System.nanoTime();
        f2    = fibonacciCached(n);
        end   = System.nanoTime();
        t2    = end-start;

        start = System.nanoTime();
        f3    = fibonacciIt(n);
        end   = System.nanoTime();
        t3    = end-start;

        System.out.printf("Elapsed nanoseconds (fibonacci):         %d,         result=%d%n", t1, f1);
        System.out.printf("Elapsed nanoseconds (fibonacciCached):   %d,         result=%d%n", t2, f2);
        System.out.printf("Elapsed nanoseconds (fibonacciIt):       %d,         result=%d%n", t3, f3);

    }

    public static void emptycache() {
        Arrays.fill(cache, -1L);
        cache[0] = 0L;
        cache[1] = 1L;
    }


}