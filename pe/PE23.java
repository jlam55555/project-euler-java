package pe;

import harness.PERunnable;
import math.Factors;

import java.util.ArrayList;
import java.util.List;

public class PE23 extends PERunnable<Integer> {

    private final int MAX = 28434;

    @Override
    public Integer run(int version) {
        int i, sum;
        int[] sieve = new int[MAX];
        List<Integer> abuns = new ArrayList<>();

        for(i=1; i<MAX; i++)
            if(Factors.sumFactors(i)>i<<1)
                abuns.add(i);

        for(int j : abuns)
            for(int k : abuns) {
                if(j+k>=MAX)
                    continue;
                sieve[j+k] = 1;
            }

        for(i=0, sum=0; i<MAX; i++)
            if(sieve[i]==0)
                sum += i;
        return sum;
    }
}
