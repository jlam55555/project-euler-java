package pe;

import harness.PERunnable;
import math.Factors;

public class PE12 extends PERunnable<Integer> {
    @Override
    public Integer run(int version) {
        int t, n;
        for(n=1, t=1; ; n++, t=n*(n+1)/2)
            if(Factors.numFactors(t) > 500)
                return t;
    }
}
