public class Palindrome {


    public Deque<Character> wordToDeque(String word){
        Deque<Character> wordDeque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i ++) {
            wordDeque.addLast(word.charAt(i));
        }

        return wordDeque;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque d = wordToDeque(word);
        return dequeIsPalindrome(d, cc);

    }
    public boolean dequeIsPalindrome(Deque d, CharacterComparator cc) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        char x = d.removeFirst().toString().toCharArray()[0];
        char y = d.removeLast().toString().toCharArray()[0];

        if (cc.equalChars(x, y)) {
            return  dequeIsPalindrome(d, cc);
        }
        return false;
    }


    public boolean isPalindrome(String word) {

        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque d = wordToDeque(word);
        return dequeIsPalindrome(d);
    }
    public boolean dequeIsPalindrome(Deque word) {
        if (word.size() == 0 || word.size() == 1) {
            return true;
        }

        if (word.removeFirst() == word.removeLast()) {


            return  dequeIsPalindrome(word);
        }
        return false;

    }




}
