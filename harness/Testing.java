package harness;

import java.lang.module.ModuleDescriptor;

public class Testing {

    public static <T extends Number> void test(PERunnable<T> r, int version) {
        test(r, version, false);
    }
    public static <T extends Number> void test(PERunnable<T> r, int version, boolean isSetup) {
        long start, end;
        T res;

        if(!isSetup) {
            r.setup();
            System.out.println("=====%n");
        }
        start = System.nanoTime();
        res = r.run(version);
        end = System.nanoTime();

        System.out.printf("problem:\t%s%nanswer:\t\t%d%nelapsed:\t%fms%n",
                r.getClass().getName(), res, (end-start)/1000000.0);
    }
    public static <T extends Number> void testMany(PERunnable<T> r, int version, int trials) {
        long start, end;
        T res;

        r.setup();
        if(trials==1 || r.getClass().isAnnotationPresent(RequiresSetup.class)) {
            if(r.getClass().isAnnotationPresent(RequiresSetup.class))
                System.out.printf("=====%nWarning: class is not restartable. Only running once.%n");
            test(r, version, true);
            return;
        }

        start = System.nanoTime();
        for(int i=0; i<trials-1; i++)
            r.run(version);
        res = r.run(version);
        end = System.nanoTime();

        System.out.printf("=====%nproblem:\t%s%nanswer:\t\t%d%n# trials:\t%d%nelapsed:\t%fms%nper trial:\t%fms%n",
                r.getClass().getName(), res, trials, (end-start)/1000000.0, (end-start)/1000000.0/trials);
    }
}
