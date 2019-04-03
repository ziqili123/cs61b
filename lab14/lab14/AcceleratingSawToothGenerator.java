package lab14;

import lab14lib.Generator;

public class AcceleratingSawToothGenerator implements Generator {
    private double factor;
    private int period;
    private int state;

    public AcceleratingSawToothGenerator (int period, double factor) {
        state = 0;
        this.period = period;
        this.factor = factor;
    }

    public double next() {
        state += 1;
        double temp =  ((double)(state % period)) / period;
        if (temp == 0) {
            period  =   (int)(period * factor);
            // at the same time, we should also increase the value of state;
            state = (int) (state * factor);
    }
    double t =  temp * 2 - 1;
        return t;
    }
}
