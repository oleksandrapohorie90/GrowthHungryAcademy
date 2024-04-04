package section_1_and_2.business.package1;

import section_1_and_2.business.package2.ClassB;

public class ClassA {
    public static void main(String[] args) {
        ClassB classB = new ClassB();
        classB.publicMethod();
       //  classB.privateMethod();
        //cannot access a protected method from the other package
    }
}
