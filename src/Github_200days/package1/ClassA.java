package Github_200days.package1;

import Github_200days.package2.ClassB;

public class ClassA {
    public static void main(String[] args) {
        ClassB classB = new ClassB();
        classB.publicMethod();
       //  classB.privateMethod();
        //cannot access a protected method from the other package
    }
}
