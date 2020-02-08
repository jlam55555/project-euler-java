package math;

import java.util.ArrayList;
import java.util.List;

public class Factors {
    // Euclidean algorithm
    public static long gcd(long m, long n) {
        if(m<1)
            return n;
        if(n<1)
            return m;
        return m>n ? gcd(n, m-m/n*n) : gcd(m, n-n/m*m);
    }

    // to avoid excessive casting on user side
    public static int gcd(int m, int n) {
        return (int) gcd((long) m, n);
    }

    public static long lcm(long m, long n) {
        return m*n/gcd(m,n);
    }

    // returns a list of factors
    public static List<Integer> factors(int n) {
        int i, srt;
        List<Integer> res = new ArrayList<>();

        for(i=1, srt=(int)Math.sqrt(n); i<=srt; i++)
            if(n%i==0) {
                res.add(i);
                res.add(n/i);
            }
        if(srt*srt==n)
            res.remove(res.size()-1);
        return res;
    }

    // returns factor count
    public static int numFactors(int n) {
        int i, cnt, srt;

        for(i=1, cnt=0, srt=(int)Math.sqrt(n); i<srt; i++)
            if(n%i==0)
                cnt += 2;
        if(srt*srt==n)
            --cnt;

        return cnt;
    }

    // returns factor sum
    public static int sumFactors(int n) {
        int i, srt, sum;

        for (i = 1, srt = (int) Math.sqrt(n), sum = 0; i <= srt; i++)
            if (n % i == 0)
                sum += i + n/i;

        if (srt * srt == n)
            sum -= srt;
        return sum;
    }
}
