package Github_200days.numbers;
import com.sun.tools.javac.Main;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.Random;

public class BigDecimal {
    public static void main(String[] args) {
        MathContext mainContext = new MathContext(7, RoundingMode.HALF_UP);
        //telling to cut in 5 meaningful numbers(dont count zeroes at the beg)
        System.out.println(new java.math.BigDecimal(".0328435").divide(new java.math.BigDecimal("5.321"),mainContext));

        System.out.println(new java.math.BigDecimal(".0328435").sqrt(mainContext));

        System.out.println(new java.math.BigDecimal("-7").abs());

        //how the modulor works %
        System.out.println(new java.math.BigDecimal("13").remainder(new java.math.BigDecimal(8)));

        byte myByte = 100;
        //BigDecimal num = new BigDecimal(myByte); //primitive double

        float num1 = 2.15f;
        float num2 = 1.10f;
        System.out.println(num1-num2);

//        BigDecimal num3 = new BigDecimal("2.15");
//        BigDecimal num4 = new BigDecimal("1.10");
//        System.out.println(num3.subtract(num4));


    }
}
