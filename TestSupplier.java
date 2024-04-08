import java.util.function.Supplier;
import java.lang.RuntimeException;

public class TestSupplier<T> implements Supplier<T> {
    private final Supplier<T> supplier;
    private final int count;
    private int useCount;

    public TestSupplier(Supplier<T> test, int max) {
        this.supplier = test;
        this.count = max;
        this.useCount = 0;
    }
    
    public T get() throws RuntimeException {
        if (count == useCount) {
            throw new RuntimeException("You used too much of it!");
        } else {
            useCount++;
            return supplier.get();
        }
    }
    
}
