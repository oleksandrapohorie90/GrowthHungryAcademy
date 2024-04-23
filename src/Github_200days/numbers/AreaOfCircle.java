package Github_200days.numbers;

public class AreaOfCircle {
    public static void main(String[] args) {
        System.out.println(calcAreaOfCircle(9));
    }

    /**
     * this method calculates the area of a circle
     * It uses the formula A = PI * r62
     * @param radius
     * @return
     */
    public static double calcAreaOfCircle(double radius){
        //A = PI * r62
        return Math.PI * Math.pow(radius,2);
    }

}
