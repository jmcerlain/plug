package divemce.com.divecalc;

public class calcfns {

    public static final double roundDouble(double d, int places) {
        return Math.round(d * Math.pow(10, (double) places)) / Math.pow(10,
                (double) places); }

    public  static final double str2double (String strval){
        double d= Double.parseDouble( strval);
        return d;
    }

}
