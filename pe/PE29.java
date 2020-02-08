package pe;

import harness.PERunnable;

import java.util.HashSet;

public class PE29 extends PERunnable<Integer> {

    final int MAX = 100;

    @Override
    public Integer run(int version) {
        int a, b;
        HashSet<Integer> logs = new HashSet<>();

        // store b*log(a); if b*log(a)=d*log(c), then a^b=c^d
        // logs multiplied to account for rounding error
        for(a=2; a<=MAX; a++)
            for(b=2; b<=MAX; b++)
                logs.add((int)(b*Math.log(a)*1000000));

        return logs.size();
    }
}
