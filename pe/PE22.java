package pe;

import harness.PERunnable;
import harness.RequiresSetup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

@RequiresSetup
public class PE22 extends PERunnable<Long> {

    private String[] names;

    // not restartable b/c sorting (in place) happens in run
    @Override
    public void setup() {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass()
                .getResourceAsStream("/in/pe22.in")))) {
            String namesStr = br.readLine();
            names = namesStr.substring(1, namesStr.length()-1).split("\",\"");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long run(int version) {
        int i;
        long tot;

        Arrays.sort(names);
        for(i=0, tot=0; i<names.length; i++)
            tot += names[i].chars().map(c -> c-'A'+1).sum() * (i+1);
        return tot;
    }
}
