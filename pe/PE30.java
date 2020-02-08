package pe;

import harness.PERunnable;

public class PE30 extends PERunnable<Integer> {
    @Override
    public Integer run(int version) {
        int a0, a1, a2, a3, a4, a5, sum, i;

        for(a0=0, sum=0; a0<10; a0++)
        for(a1=0; a1<10; a1++)
        for(a2=0; a2<10; a2++)
        for(a3=0; a3<10; a3++)
        for(a4=0; a4<10; a4++)
        for(a5=0; a5<10; a5++)
            if(Math.pow(a0,5)+Math.pow(a1,5)+Math.pow(a2,5)+Math.pow(a3,5)+Math.pow(a4,5)+Math.pow(a5,5) ==
                    (i=a0+a1*10+a2*100+a3*1000+a4*10000+a5*100000))
                sum += i;

        return sum-1;
    }
}
