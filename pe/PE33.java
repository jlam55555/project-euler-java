package pe;

import harness.PERunnable;
import math.Factors;

public class PE33 extends PERunnable<Integer> {
    @Override
    public Integer run(int version) {

        int num, den, gcd, numRed, denRed, crossNum, crossDen, resNum, resDen;
        for(num=10, resNum=1, resDen=1; num<100; num++) {
            for(den=99; den>num; den--) {

                // these are the "trivial" cases
                if(num%10==0 || den%10==0 || num/10==num%10)
                    continue;

                // calculate "real quotient"
                if((gcd = Factors.gcd(num, den)) == 1)
                    continue;
                numRed = num/gcd;
                denRed = den/gcd;

                // check "cross quotient"; other cross quotient might also be the case though
                if(num%10==den/10) {
                    gcd = Factors.gcd(crossNum=num/10, crossDen=den%10);
                    if (crossNum/gcd==numRed && crossDen/gcd==denRed) {
                        resNum *= numRed;
                        resDen *= denRed;
                    }
                }
            }
        }

        return resDen/Factors.gcd(resNum, resDen);
    }
}
