package pe;

import harness.PERunnable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collector;

public class PE32 extends PERunnable<Integer> {

    private static void fillDigits(int n, boolean[] digs) {
        while(n>0) {
            digs[n%10] = true;
            n /= 10;
        }
    }

    @Override
    public Integer run(int version) {
        int i, j;
        boolean[] digs = new boolean[10];
        HashSet<Integer> products = new HashSet<>();

        for(i=100; i<10000; i++)
            for(j=10000/i; j>0 && (int)(2*Math.log10(i*j))==7; j--) {
                Arrays.fill(digs, false);

                fillDigits(i, digs);
                fillDigits(j, digs);
                fillDigits(i*j, digs);

                if(digs[1] && digs[2] && digs[3] && digs[4] && digs[5] && digs[6] && digs[7] && digs[8] && digs[9])
                    products.add(i*j);
            }

        return products.stream().mapToInt(k->k).sum();
    }
}
