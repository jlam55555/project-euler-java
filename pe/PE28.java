package pe;

import harness.PERunnable;

public class PE28 extends PERunnable<Integer> {

    private final int N = 1001;

    private int method1() {
        int n, sum;
        for(n=1, sum=0; n<N/2+1; n++)
            sum += 4*(2*n+1)*(2*n+1)-12*n;
        return sum+1;
    }

    private int method2() {
        int n = N/2;
        return (16*n*n*n + 30*n*n + 26*n)/3+1;
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
