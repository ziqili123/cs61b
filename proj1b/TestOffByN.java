import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    OffByN OffByN = new OffByN(2);

    // Your tests go here.
    @Test
    public void testEqualChars() {

        assertFalse(OffByN.equalChars('a','b'));
        assertTrue(OffByN.equalChars('c','e'));
        assertTrue(OffByN.equalChars('g','i'));
    }
}
