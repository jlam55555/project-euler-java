package pe;

import harness.PERunnable;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PE8 extends PERunnable<Long> {
    private String content;

    @Override
    public void setup() {
        content = "";
        try {
            content = Files.readString(Paths.get(getClass().getResource("/in/pe8.in").toURI()),
                    StandardCharsets.US_ASCII);
        } catch (Exception e) { }
        content = content.replace("\n", "");
    }

    @Override
    public Long run(int version) {
        int i, j;
        long cur, max;

        for(i=0, max=0; i<1000-13; i++) {
            for(j=0, cur=1; j<13; j++)
                cur *= content.charAt(i+j)-'0';
            if(cur > max)
                max = cur;
        }
        return max;
    }
}
