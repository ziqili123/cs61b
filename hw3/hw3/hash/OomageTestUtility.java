package hw3.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        HashMap<Integer, Integer> hashcodes = new HashMap<>();

        int lowBound = oomages.size() / 50;
        int highBound =  (int) (oomages.size() / 2.5);

        for (Oomage oomage : oomages) {
            int bucketNum = (oomage.hashCode() & 0x7FFFFFFF) % M;
            if (hashcodes.containsKey(bucketNum)) {
                hashcodes.put(bucketNum, hashcodes.get(bucketNum) + 1);
            } else {
                hashcodes.put(bucketNum, 1);
            }
        }
        Set<Integer> keys = hashcodes.keySet();
        for (int k : keys) {
            int value = hashcodes.get(k);
            if (value <= lowBound || value >= highBound) {
                return false;
            }
        }
       return true;
    }
}
