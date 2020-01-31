package math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.function.Supplier;

public class Sequences {

    private static final double r5 = Math.sqrt(5);
    private static final double phi = (1+r5)/2;
    public static long binet(int n) {
        return Math.round(Math.pow(phi, n)/r5);
    }

    private static final BigDecimal br5 = BigDecimal.valueOf(5).sqrt(MathContext.DECIMAL32);
    private static final BigDecimal bphi = br5.add(BigDecimal.ONE).divide(BigDecimal.valueOf(2), MathContext.DECIMAL32);
    public static BigInteger bbinet(int n) {
        return bphi.pow(n).divide(br5, MathContext.DECIMAL32).toBigInteger();
    }

    public static class FibStream implements Supplier<Integer> {
        int i = 0;
        int j = 1;

        @Override
        public Integer get() {
            int tmp = j;
            j += i;
            i = tmp;
            return i;
        }
    }

    public static class BFibStream implements Supplier<BigInteger> {
        BigInteger i = BigInteger.ZERO;
        BigInteger j = BigInteger.ONE;

        @Override
        public BigInteger get() {
            BigInteger tmp = j;
            j = j.add(i);
            i = tmp;
            return i;
        }
    }
}
