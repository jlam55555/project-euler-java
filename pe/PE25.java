package pe;

import harness.PERunnable;
import math.Sequences;

import java.util.stream.Stream;

public class PE25 extends PERunnable<Integer> {

    private final int LEN = 1000;

    private final int SRCH_MIN = 1000;
    private final int SRCH_MAX = 10000;

    private int method1() {
        int intvl, i;

        // binary search in provided range
        for(i=(SRCH_MAX+SRCH_MIN)/2, intvl=(SRCH_MAX-SRCH_MIN)/4; i>SRCH_MIN && i<SRCH_MAX;) {
            if(Sequences.bbinet(i).toString().length() >= LEN) {
                if(Sequences.bbinet(i-1).toString().length() < LEN)
                    return i;
                i -= intvl;
            } else
                i += intvl;

            if(intvl>1)
                intvl /= 2;
        }

        return -1;
    }

    private int method2() {
        return (int)Stream.generate(new Sequences.BFibStream()).takeWhile(n->n.toString().length()<1000).count()+1;
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
