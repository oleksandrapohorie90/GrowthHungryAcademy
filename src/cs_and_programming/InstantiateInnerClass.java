package cs_and_programming;

public class InstantiateInnerClass {
//    To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within the outer object with this syntax:

//    OuterClass outerObject = new OuterClass();
//    OuterClass.InnerClass innerObject = outerObject.new InnerClass();

    //Constructor
//    public Bicycle(int startCadence, int startSpeed, int startGear) {
//        gear = startGear;
//        cadence = startCadence;
//        speed = startSpeed;
//    }
//    To create a new Bicycle object called myBike, a constructor is called by the new operator:
//
//    Bicycle myBike = new Bicycle(30, 0, 8);
//new Bicycle(30, 0, 8) creates space in memory for the object and initializes its fields.
//
//    Although Bicycle only has one constructor, it could have others, including a no-argument constructor:
//
//    public Bicycle() {
//        gear = 1;
//        cadence = 10;
//        speed = 0;
//    }
//    Bicycle yourBike = new Bicycle(); invokes the no-argument constructor to create a new Bicycle object called yourBike.

    //params vs arguments
    //Parameters refers to the list of variables in a method declaration. Arguments are the actual values that are passed in when the method is invoked. When you invoke a method, the arguments used must match the declaration's parameters in type and order.

//    public double computePayment(
//            double loanAmt,
//            double rate,
//            double futureValue,
//            int numPeriods) {
//        double interest = rate / 100.0;
//        double partial1 = Math.pow((1 + interest),
//                - numPeriods);
//        double denominator = (1 - partial1) / interest;
//        double answer = (-loanAmt / denominator)
//                - ((futureValue * partial1) / denominator);
//        return answer;
//    }
//    This method has four parameters: the loan amount, the interest rate, the future value and the number of periods. The first three are double-precision floating point numbers, and the fourth is an integer. The parameters are used in the method body and at runtime will take on the values of the arguments that are passed in.

    //varargs
//    To use varargs, you follow the type of the last parameter by an ellipsis (three dots, ...), then a space, and the parameter name. The method can then be called with any number of that parameter, including none.
//
//    public Polygon polygonFrom(Point... corners) {
//        int numberOfSides = corners.length;
//        double squareOfSide1, lengthOfSide1;
//        squareOfSide1 = (corners[1].x - corners[0].x)
//                * (corners[1].x - corners[0].x)
//                + (corners[1].y - corners[0].y)
//                * (corners[1].y - corners[0].y);
//        lengthOfSide1 = Math.sqrt(squareOfSide1);

        // more method body code follows that creates and returns a
        // polygon connecting the Points
    }

