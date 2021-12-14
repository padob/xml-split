import org.junit.jupiter.api.Test;

class LoaderTest {
    private Loader loader;

    @Test
    void starter() {
        loader = new Loader();
        loader.load();
    }
}