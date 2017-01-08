package divemce.com.divecalc;

/**
 * Created by Teameprop on 1/7/2017.
 */

public class calcfns {

    public static final double roundDouble(double d, int places) {
        return Math.round(d * Math.pow(10, (double) places)) / Math.pow(10,
                (double) places); }
}
