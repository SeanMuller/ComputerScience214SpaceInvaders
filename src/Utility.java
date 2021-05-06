//Class to hold all the utility functions

public class Utility {
    //Private constructor to prevent a instance of the class from getting instantiated
    private Utility() {
    }

    //Limit a number between an upper and lower bound
    public static double limitBounds(double num, double lower, double upper) {
        if (num < lower) {
            num = lower;
        }

        if (num > upper) {
            num = upper;
        }

        return num;
    }
}
