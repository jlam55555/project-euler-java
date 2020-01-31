package pe;

import harness.PERunnable;

public class PE6 extends PERunnable<Integer> {
    @Override
    public Integer run(int version) {
        int n = 100;
        return (n*n*n*n+2*n*n*n+n*n)/4-n*(n+1)*(2*n+1)/6;
    }
}
