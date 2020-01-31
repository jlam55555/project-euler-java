package math;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Primes {
    public static boolean isPrime(int n) {
        for(int i = 2; i<= sqrt(n); i++)
            if(n%i == 0)
                return false;
        return true;
    }

    public static List<Integer> sieve(int n) {
        List<Integer> primes = new ArrayList<>();
        int i, j;
        boolean[] composites = new boolean[n];

        for(i=2; i<sqrt(n); i++)
            if(!composites[i])
                for(j=i*i; j<n; j+=i)
                    composites[j] = true;

        for(i=2; i<n; i++)
            if(!composites[i])
                primes.add(i);

        return primes;
    }
}
