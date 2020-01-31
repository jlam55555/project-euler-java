package pe;

import harness.PERunnable;

public class PE14 extends PERunnable<Integer> {
    @Override
    public Integer run(int version) {
        int i, len, longest, longestLen;
        long col;

        // store previous values up to RES_MAX; 10000 seems to have good speed
        final int RES_MAX = 10000;
        int[] res = new int[RES_MAX];

        for(i=1, col=1L, len=0, longest=-1, longestLen=0; i<1000000; i+=2, col=i, len=0) {
            while(col != 1) {
                if(col%2==0)
                    col /= 2;
                else
                    col = 3*col+1;
                if(col < RES_MAX && res[(int)col] != 0) {
                    len += res[(int)col];
                    res[i] = len;
                    break;
                }
                len++;
            }
            if(len > longestLen) {
                longestLen = len;
                longest = i;
            }
        }
        return longest;
    }
}
