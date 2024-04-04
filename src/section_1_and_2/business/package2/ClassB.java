package section_1_and_2.business.package2;

public class ClassB {

    public void publicMethod(){
        System.out.println("This is a public method of class B");
        privateMethod();
    }
    private void privateMethod(){
        System.out.println("This is a private method of class B");
    }

    protected void protectedMethod(){
        System.out.println("This is the protected method of class B");
    }

//subclassing is the difference btw prottected and package protected
    void packageProtected(){
        System.out.println("This is the package protected of class B");
    }
}
