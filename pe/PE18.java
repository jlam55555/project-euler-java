package pe;

import harness.PERunnable;
import harness.RequiresSetup;

import java.util.Scanner;

// same as pe67, but with different input and n
@RequiresSetup
public class PE18 extends PERunnable<Integer> {

    private int[][] tri;
    private int n = 15;

    @Override
    public void setup() {
        Scanner in = new Scanner(getClass().getResourceAsStream("/in/pe18.in"));
        int i, j;

        tri = new int[n][n];
        for(i=0; i<n; i++)
            for(j=0; j<=i; j++)
                tri[i][j] = in.nextInt();
    }

    @Override
    public Integer run(int version) {
        int i, j;

        for(i=n-2; i>=0; i--)
            for(j=0; j<=i; j++)
                tri[i][j] += Math.max(tri[i+1][j], tri[i+1][j+1]);

        return tri[0][0];
    }
}
