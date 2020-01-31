package pe;

import harness.PERunnable;

import java.math.BigInteger;

public class PE97 extends PERunnable<Long> {
    private long method1() {
        BigInteger exp = BigInteger.valueOf(7830457),
                mod = BigInteger.valueOf(10000000000L),
                coef = BigInteger.valueOf(28433),
                one = BigInteger.ONE,
                two = BigInteger.TWO;
        return two.modPow(exp, mod).multiply(coef).add(one).mod(mod).longValue();
    }

    private long method2() {
        int i;
        long n = 28433;

        for(i=0; i<7830457; i++)
            n = (n<<1) % 10000000000L;
        return n+1;
    }

    @Override
    public Long run(int version) {
        switch(version) {
        case 0:
            return method1();
        case 1:
            return method2();
        }
        return -1L;
    }
}
