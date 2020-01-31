package pe;

import harness.PERunnable;

public class PE9 extends PERunnable<Integer> {
    @Override
    public Integer run(int version) {
        int i, j, k;
        for(i=3; i<1000; i++)
            for(j=2; j<i; j++)
                for(k=1; k<j; k++)
                    if(k*k+j*j==i*i && i+j+k==1000)
                        return i*j*k;
        return -1;
    }
}
