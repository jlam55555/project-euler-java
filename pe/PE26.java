package pe;

import harness.PERunnable;

public class PE26 extends PERunnable<Integer> {
    @Override
    public Integer run(int version) {
        int i, j, k, longest, longestI, divisor, dividend, chainLen;
        int[] divisors;

        for(i=2, longest=0, longestI=-1; i<1000; i++) {
            for(j=0, divisor=1, dividend=i, divisors = new int[1000], chainLen=0; divisor!=0; j++) {
                while(divisor<dividend)
                    divisor *= 10;
                divisors[j] = divisor %= dividend;
                for(k=0; k<j; k++)
                    if(divisors[k]==divisor) {
                        chainLen = j-k;
                        break;
                    }
                if(chainLen>0)
                    break;
            }

            if(chainLen>longest) {
                longest = chainLen;
                longestI = i;
            }
        }

        return longestI;
    }
}
