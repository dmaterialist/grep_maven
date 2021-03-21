import grep.Grep;
import org.junit.*;
public class GrepTest {
    @Test
    public void easyTest() {
        Grep grep = new Grep(false, false, true);
        grep.search("kl", "easy_test.txt");
    }
}
