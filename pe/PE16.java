package pe;

import harness.PERunnable;

import java.math.BigInteger;

public class PE16 extends PERunnable<Integer> {
    @Override
    public Integer run(int version) {
        return BigInteger.TWO.pow(1000).toString().chars().map(i->i-'0').sum();
    }
}
