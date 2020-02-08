package pe;

import harness.PERunnable;
import harness.RequiresSetup;

// DP -- have to reset array
@RequiresSetup
public class PE31 extends PERunnable<Integer> {

    // order doesn't matter here
    private final int[] denoms = new int[]{200, 100, 50, 20, 10, 5, 2, 1};

    // bottom-up approach
    private int method1() {
        int[] perms = new int[201];
        int i;

        perms[0] = 1;
        for(int j : denoms)
            for(i=j; i<=200; i++)
                perms[i] += perms[i-j];

        return perms[200];
    }

    // top-down approach
    private int[][] cachedRes = new int[201][8];
    private int topDown(int amount, int denom) {
        if(denom>=8 || amount<0)
            return 0;
        if(cachedRes[amount][denom] > 0)
            return cachedRes[amount][denom];
        return cachedRes[amount][denom] = topDown(amount-denoms[denom], denom) + topDown(amount, denom+1);
    }
    private int method2() {
        int i;
        for(i=0; i<8; i++)
            cachedRes[0][i] = 1;
        return topDown(200, 0);
    }

    @Override
    public Integer run(int version) {
        switch (version) {
        case 0:
            return method1();
        case 1:
            return method2();
        }
        return -1;
    }
}
