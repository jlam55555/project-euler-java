package pe;

import harness.PERunnable;
import math.Primes;

public class PE10 extends PERunnable<Long> {
    @Override
    public Long run(int version) {
        return Primes.sieve(2000000).stream().mapToLong(Integer::intValue).sum();
    }
}
