package pe;

import harness.PERunnable;
import math.Primes;

public class PE27 extends PERunnable<Integer> {
    @Override
    public Integer run(int version) {
        int a, b, n, longest, longestAb;

        final int MAX = 100000;
        boolean[] comps = new boolean[MAX];
        Primes.sieve(MAX, comps);

        for(b=-1000, longest=0, longestAb=-1; b<1001; b++) {
            if(comps[Math.abs(b)])
                continue;
            for(a=-999; a<1000; a++) {
                for(n=0; n<Math.abs(b) && !comps[Math.abs(n*n+a*n+b)]; n++);
                if(n>longest) {
                    longest = n;
                    longestAb = a*b;
                }
            }
        }
        return longestAb;
    }
}
