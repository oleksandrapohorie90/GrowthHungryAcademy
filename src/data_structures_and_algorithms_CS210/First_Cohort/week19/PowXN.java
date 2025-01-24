package data_structures_and_algorithms_CS210.First_Cohort.week19;

public class PowXN {
    //power -> x ^ n
    //implement pow(x,n) which calculates x raised to the power n (i.e, x^n)

    public double myPow(double x, int n) {
        long exponent = (long) n;
        if (exponent < 0) {
            exponent = -exponent;
            x = 1 / x;
        }
        return myPow_(x, exponent);
    }

    private double myPow_(double x, long exponent) {
        if (exponent == 0) {
            return 1;
        }
        //even n, x^n = (x^2)^(n/2)   =x^(2*(n/2))
        //e.g. x^6 = (x^2)^3 = x^(2*3)

        //odd n, x^n = (x^2)(n/2) * x = x ^(2*(n/2)) * x = x^(n-1) * x,
        //                                                 because 2*(n/2) = n - 1 for (n/2) is floored,
        //i.e. for odd n=7, n/2 will be 3, not 3.5
        //e.g. x^7 = (x^2)^3 * x = x^(2*3) *x = x^6 * x
        return (exponent % 2 == 0) ? myPow_(x * x, exponent / 2) :
                myPow_(x * x, exponent / 2) * x;
    }
}
