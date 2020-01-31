package pe;

import harness.PERunnable;

import static math.Factors.lcm;

public class PE5 extends PERunnable<Long> {
    @Override
    public Long run(int version) {
        long i, res;
        for(i=1, res=1; i<20; i++)
            res = lcm(i, res);
        return res;
    }
}
