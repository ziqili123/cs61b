package lab14;
import lab14lib.Generator;

public class StrangeBitwiseGenerator implements Generator {

    private int period;
    private int state;

    public StrangeBitwiseGenerator(int period) {

        state = 0;
        this.period = period;
    }

    public double next (){
        state += 1;
        double temp = (double)((state & (state >>> 7) % period) / period;
        return temp * 2 - 1;
    }
}
