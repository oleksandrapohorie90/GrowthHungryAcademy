package cs_assembly;

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
}
