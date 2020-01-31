package pe;

import harness.PERunnable;
import math.Powers;

public class PE20 extends PERunnable<Integer> {

    private final int n = 100;
    @Override
    public Integer run(int version) {
        return Powers.fac(100).toString().chars().map(i->i-'0').sum();
    }
}
