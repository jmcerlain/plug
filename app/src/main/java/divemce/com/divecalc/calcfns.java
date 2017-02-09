package divemce.com.divecalc;

public class calcfns {

    public static final double roundDouble(double d, int places) {
        return Math.round(d * Math.pow(10, (double) places)) / Math.pow(10,
                (double) places); }

    public  static final double str2double (String strval){
        double d= Double.parseDouble( strval);
        return d;
    }

    // convert string to double
    // if not valid, return 0
    public  static final double str_to_double (String strval){
        try {
            double d = Double.parseDouble(strval);
            return d;
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }
	
	
	    // convert string to integer
    // if not valid, return 0
    public  static final int str_to_int (String strval){
        try {
            int i = Integer.parseInt(strval);
            return i;
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }

}
