public class OffByOne implements CharacterComparator {



    public boolean equalChars(char x, char y) {
        if (x - y == 1) {
            return true;
        }
        if (y - x == 1) {
            return true;
        }
        return false;
    }


}
