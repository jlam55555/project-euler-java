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

    // this uses a custom multiplication algorithm to bypass
    // using BigInteger; much faster but optimized for this problem
    // with the answer in mind
    final static long z = 10000000000L;
    private long lmm(long m, long n) {
        long a = m>>24,
             b = m&0xffffff,
             c = n>>24,
             d = n&0xffffff;
        return (((((a*c)<<24)%z)<<24)%z + ((a*d%z)<<24)%z
                + ((b*c%z)<<24)%z + b*d%z)%z;
    }
    private long method4() {
        long r, x, n;
        for(r = 28433,
            x = 2,
            n = 7830457;
            n>0; n>>=1) {
            if((n&1)==1)
                r = lmm(r,x);
            x = lmm(x,x);
        }
        return r+1;
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
        case 3:
            return method4();
        }
        return -1L;
    }
}
