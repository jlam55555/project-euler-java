package pe;

import harness.PERunnable;

import java.util.Scanner;

public class PE11 extends PERunnable<Integer> {
    private int[][] mat;
    private final int n = 20, m = 4;

    @Override
    public void setup() {
        int i, j;

        mat = new int[n][n];
        Scanner in = new Scanner(getClass().getResourceAsStream("/in/pe11.in"));
        for(i=0; i<n; i++)
            for(j=0; j<n; j++)
                mat[i][j] = in.nextInt();
    }

    @Override
    public Integer run(int version) {
        int max, i, j, prod;

        for(i=0, max=0; i<n; i++)
            for(j=0; j<n; j++) {
                if(n-i>=m && (prod=mat[i][j]*mat[i+1][j]*mat[i+2][j]*mat[i+3][j])>max)
                    max = prod;
                if(n-j>=m && (prod=mat[i][j]*mat[i][j+1]*mat[i][j+2]*mat[i][j+3])>max)
                    max = prod;
                if(n-i>=m && n-j>=m && (prod=mat[i][j]*mat[i+1][j+1]*mat[i+2][j+2]*mat[i+3][j+3])>max)
                    max = prod;
                if(n-i>=m && j>=m-1 && (prod=mat[i][j]*mat[i+1][j-1]*mat[i+2][j-2]*mat[i+3][j-3])>max)
                    max = prod;
            }
        return max;
    }
}
