package pe;

import harness.PERunnable;
import math.Factors;

public class PE21 extends PERunnable<Integer> {
    private final int n = 10000;

    @Override
    public Integer run(int version) {
        int i, j, sum;
        int[] res = new int[n];

        for(i=2, sum=0; i<n; i++) {
            if(res[i]!=0) {
                if (res[i] == 1)
                    sum += i;
                continue;
            }

            j = Factors.sumFactors(i)-i;

            if(i == j)
                continue;
            if(j < 0)
                continue;
            if(j < n)
                res[j] = -1;
            if(Factors.sumFactors(j)-j == i) {
                sum += i;
                if(j < n)
                    res[j] = 1;
            }
        }
        return sum;
    }
}
