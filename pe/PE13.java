package pe;

import harness.PERunnable;

import java.util.Arrays;
import java.util.Scanner;

public class PE13 extends PERunnable<Long> {
    private long ints[];
    private final int n = 100;

    // this does a little bit of unfair preprocessing, I guess
    @Override
    public void setup() {
        int i;

        ints = new long[n];
        Scanner sc = new Scanner(getClass().getResourceAsStream("/in/pe13.in"));
        for(i=0; i<n; i++)
            ints[i] = Long.valueOf(sc.nextLine().substring(0, 11));
    }

    @Override
    public Long run(int version) {
        return Arrays.stream(ints).sum()/1000;
    }
}
