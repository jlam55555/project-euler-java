package pe;

import harness.PERunnable;

public class PE4 extends PERunnable<Integer> {
    @Override
    public Integer run(int version) {
        int i, j, prod, max;
        final int MAX=999, MIN=900;

        for(i=MAX, max=0; i>MIN; i--)
            for(j=MAX; j>MIN && (prod=i*j)>max; j--)
                if(prod%10==prod/100000 && prod/10%10==prod/10000%10 && prod/100%10==prod/1000%10)
                    max = prod;
        return max;
    }
}
