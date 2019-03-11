public class OffByN implements CharacterComparator {



    int N;
    public OffByN(int N) {
        this.N = N;
    }

    public boolean equalChars(char x, char y) {
        if (x - y == this.N) {
            return true;
        }
        if (y - x == this.N) {
            return true;
        }
        return false;
    }
    }



