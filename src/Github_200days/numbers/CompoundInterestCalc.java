package Github_200days.numbers;

public class CompoundInterestCalc {
    public static void main(String[] args) {

    }
    public static BigDecimal calculate(String principal, String rate, int period, String contribution) {
        // Balance(Y) = P(1+r)Y + c[((1+r)Y-1)/r]
//        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rate)).pow(period); //(1+r)^period
//
//        BigDecimal c = b.subtract(BigDecimal.ONE); //((1+r)^Y-1)
//        BigDecimal d = c.divide(new BigDecimal(rate)); //((1+r)^Y-1)/r
//        BigDecimal e = d.multiply(new BigDecimal(contribution)) //c[((1+r)Y-1)/r]
//        BigDecimal f = a.multiply(new BigDecimal(principal));
//        BigDecimal g = f.add(e);
//        return g;
    return new BigDecimal(); }
}
