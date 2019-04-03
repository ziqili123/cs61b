package lab14;
import edu.princeton.cs.algs4.StdAudio;
import lab14lib.Generator;
public class SawToothGenerator implements Generator {

    private int period;
    private int state;

    public SawToothGenerator(int period) {

        state = 0;
        this.period = period;
    }

    public double next (){
        state += 1;
        double temp = (double)(state % period) / period;
        return temp * 2 - 1;
    }
}
