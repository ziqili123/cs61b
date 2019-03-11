import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testisPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));

        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("noon"));
         assertTrue(palindrome.isPalindrome("asdfghjklkjhgfdsa"));}

    @Test
    public void testisPalindrome2() {
        OffByOne cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("ab", cc));
        assertFalse(palindrome.isPalindrome("ce", cc));
        assertTrue(palindrome.isPalindrome("ab", cc));
        assertTrue(palindrome.isPalindrome("nm", cc));
    }
}
