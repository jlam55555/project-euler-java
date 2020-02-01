package harness;

public abstract class PERunnable<T extends Number> {
    public PERunnable() {}

    // override if setup necessary; annotate with "RequiresSetup" if setup is mutated between runs
    public void setup() { }
    public abstract T run(int version);
}
