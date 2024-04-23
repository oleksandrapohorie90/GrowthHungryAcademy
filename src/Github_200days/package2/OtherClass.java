package Github_200days.package2;

public class OtherClass {
    public void method1(){
        ClassB classB = new ClassB();
        //protected method can be accessed withing the same package
        classB.protectedMethod();
        classB.packageProtected();
    }
}
