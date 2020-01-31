package pe;

import harness.PERunnable;

public class PE15 extends PERunnable<Long> {

    private final int n = 20;

    // dp solution; can use combinatorics instead (40!/20!/20!)
    @Override
    public Long run(int version) {
        long[][] matrix = new long[n+1][n+1];
        int i, j;

        for(i=0; i<n; i++)
            matrix[n][i] = matrix[i][n] = 1;

        for(i=n-1; i>=0; i--)
            for(j=n-1; j>=0; j--)
                matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];

        return matrix[0][0];
    }
}
