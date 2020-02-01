package pe;

import harness.PERunnable;

import java.math.BigInteger;

public class PE97 extends PERunnable<Long> {
    private long method1() {
        BigInteger exp = BigInteger.valueOf(7830457),
                mod = BigInteger.valueOf(10000000000L),
                coef = BigInteger.valueOf(28433),
                two = BigInteger.TWO;
        return two.modPow(exp, mod).multiply(coef).mod(mod).longValue()+1;
    }

    private long method2() {
        int i;
        long n = 28433;

        for(i=0; i<7830457; i++)
            n = (n<<1) % 10000000000L;
        return n+1;
    }

    // self-implemented modpow with repeated squaring, like method1
    // if one less digit in mod, could implement with simply longs grrr
    // a little slower than using modpow
    private long method3() {
        BigInteger r, z, x, n;
        for(r = BigInteger.valueOf(28433),
            z = BigInteger.valueOf(10000000000L),
            x = BigInteger.TWO,
            n = BigInteger.valueOf(7830457);
            n.signum()!=0; n = n.shiftRight(1)) {
            if(n.testBit(0))
                r = r.multiply(x).mod(z);
            x = x.multiply(x).mod(z);
        }
        return r.longValue()+1;
    }

    @Override
    public Long run(int version) {
        switch(version) {
        case 0:
            return method1();
        case 1:
            return method2();
        case 2:
            return method3();
        }
        return -1L;
    }
}
