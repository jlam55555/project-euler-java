package pe;

import harness.PERunnable;

public class PE1 extends PERunnable<Integer> {

    private int sumOneToN(int n) {
        return n*(n+1)/2;
    }

    private int method1() {
       return 3*sumOneToN(999/3)+5*sumOneToN(999/5)-15*sumOneToN(999/15);
    }

    private int method2() {
        int sum=0, i;
        for(i=3; i<1000; i+=3)
            sum += i;
        for(i=5; i<1000; i+=5)
            sum += i;
        for(i=15; i<1000; i+=15)
            sum -= i;
        return sum;
    }

    private int method3() {
        int i, sum;
        for(i=0, sum=0; i<1000; i++)
            if(i%3==0 || i%5==0)
                sum += i;
        return sum;
    }

    @Override
    public Integer run(int num) {
        int res;
        switch(num) {
        case 0:
            return method1();
        case 1:
            return method2();
        case 2:
            return method3();
        }
        return -1;
    }
}
