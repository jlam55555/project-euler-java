package math;

import java.math.BigInteger;

public class Powers {

    // modpow for faster pe97

    public static BigInteger fac(int n) {
        BigInteger res;
        int m;
        for(res=BigInteger.ONE, m=2; m<=n; m++)
            res = res.multiply(BigInteger.valueOf(m));
        return res;
    }

    public static long lfac(int n) {
        long res;
        int m;
        for(res = 1L, m=2; m<=n; m++)
            res *= m;
        return res;
    }
}
