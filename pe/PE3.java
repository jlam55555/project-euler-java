package pe;

import harness.PERunnable;
import math.Primes;

public class PE3 extends PERunnable<Integer> {
    @Override
    public Integer run(int version) {
        long n = 600851475143L;
        int i;

        for(i=(int)Math.sqrt(n); i>2; i--)
            if(n%i==0 && Primes.isPrime(i))
                return i;

        return null;
    }
}
