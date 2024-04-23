package Github_200days.business.numbers;

public class MathClass {
    public static void main(String[] args) {
        System.out.println(Math.abs(-5)); //absolute form is 5
        System.out.println(Math.ceil(5.01)); //will round up to 6, unless it is 5.0-wont do anything
        System.out.println(Math.floor(5.99)); //will go down to the floor and be 5.0

        int num1 = 3;
        int num2 = 5;
        System.out.println(Math.min(num1,num2)); //absolute form is 3
        System.out.println(Math.max(num1,num2)); //absolute form is 5

        System.out.println(Math.random());//generates double number
        System.out.println((int)(Math.random()*10));//force a double to be an integer

        //round ups when it is 5.5 to 6, when less goes down to 5.0
        System.out.println(Math.round(5.1));
        System.out.println(Math.round(5.99));
        System.out.println(Math.round(5.4));

        //9
        System.out.println(Math.sqrt(81));

        //PI, E
        System.out.println(Math.E);
        System.out.println(Math.PI);
        //Ctrl+Q to get the documentation
        System.out.println(Math.ceilDiv(10,10));




    }

}
