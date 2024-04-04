package section_1_and_2.business.model;

public class Turtle extends Pet{
    public void hide(){
        //cn access bc it extends Pet class
        super.packageProtected();
        super.protectedMethod();
    }
}
