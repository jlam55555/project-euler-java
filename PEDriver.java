import harness.Testing;
import pe.*;

public class PEDriver {
    public static void main(String[] args) {
        runAll();
    }

    public static void runAll() {
        final int TRLS = 8;
        Testing.testMany(new PE1(), 0, TRLS);
        Testing.testMany(new PE1(), 1, TRLS);
        Testing.testMany(new PE1(), 2, TRLS);
        Testing.testMany(new PE2(), 0, TRLS);
        Testing.testMany(new PE2(), 1, TRLS);
        Testing.testMany(new PE3(), 0, TRLS);
        Testing.testMany(new PE4(), 0, TRLS);
        Testing.testMany(new PE5(), 0, TRLS);
        Testing.testMany(new PE6(), 0, TRLS);
        Testing.testMany(new PE7(), 0, TRLS);
        Testing.testMany(new PE7(), 1, TRLS);
        Testing.testMany(new PE8(), 0, TRLS);
        Testing.testMany(new PE9(), 0, TRLS);
        Testing.testMany(new PE10(), 0, TRLS);
        Testing.testMany(new PE11(), 0, TRLS);
        Testing.testMany(new PE12(), 0, TRLS);
        Testing.testMany(new PE13(), 0, TRLS);
        Testing.testMany(new PE14(), 0, TRLS);
        Testing.testMany(new PE15(), 0, TRLS);
        Testing.testMany(new PE16(), 0, TRLS);
        Testing.testMany(new PE18(), 0, TRLS);
        Testing.testMany(new PE20(), 0, TRLS);
        Testing.testMany(new PE21(), 0, TRLS);
        Testing.testMany(new PE22(), 0, TRLS);
        Testing.testMany(new PE23(), 0, TRLS);
        Testing.testMany(new PE24(), 0, TRLS);
        Testing.testMany(new PE25(), 0, TRLS);
        Testing.testMany(new PE67(), 0, TRLS);
        Testing.testMany(new PE97(), 0, TRLS);
        Testing.testMany(new PE97(), 1, TRLS);
        Testing.testMany(new PE97(), 2, TRLS);
        Testing.testMany(new PE97(), 3, TRLS);
    }
}
