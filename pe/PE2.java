package pe;

import harness.PERunnable;
import math.Sequences;

import java.util.stream.Stream;

public class PE2 extends PERunnable<Integer> {

    private int method1() {
        long res;
        int sum, i;

        for(i=0, sum=0; ; i+=3) {
            if((res= Sequences.binet(i)) > 4000000)
                break;
            sum += res;
        }
        return sum;
    }

    private int method2() {
        return Stream.generate(new Sequences.FibStream())
            .takeWhile(n -> n < 4000000)
            .filter(n -> n%2==0)
            .reduce(0, (u, v) -> u+v);
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
