package pe;

import harness.PERunnable;

import static math.Primes.isPrime;
import static math.Primes.sieve;

public class PE7 extends PERunnable<Integer> {
    private int method1() {
        return sieve(105000).get(10000);
    }
    private int method2() {
        int i, count;
        for(i=2, count=0; count<10001; i++)
            if(isPrime(i))
                count++;

        return i-1;
    }

    @Override
    public Integer run(int version) {
        switch(version) {
        case 0:
            return method1();
        case 1:
            return method2();
        }
        return -1;
    }
}
