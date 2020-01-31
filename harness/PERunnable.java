package harness;

public abstract class PERunnable<T extends Number> {
    // override if setup necessary; annotate with "RequiresSetup" if setup is mutated between runs
    public void setup() { }
    public abstract T run(int version);
}
