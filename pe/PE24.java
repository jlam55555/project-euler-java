package pe;

import harness.PERunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static math.Powers.lfac;

public class PE24 extends PERunnable<Long> {

    private final long N = 1000000;
    private final int len = 10;

    @Override
    public Long run(int version) {
        List<Integer> digs = IntStream.range(0, 10).boxed().collect(Collectors.toCollection(ArrayList::new)),
                      res = new ArrayList<>();
        long n = N-1;   // -1 for correct indexing
        int i, j;

        for(i=len-1; i>=0; i--) {
            j = (int)(n/lfac(i));
            res.add(digs.remove(j));
            n %= lfac(i);
        }
        return Long.valueOf(res.stream().map(k->""+k).collect(Collectors.joining()));
    }
}
