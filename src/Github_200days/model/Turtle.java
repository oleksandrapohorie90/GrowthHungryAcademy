package Github_200days.model;

public class Turtle extends Pet{
    public void hide(){
        //cn access bc it extends Pet class
        super.packageProtected();
        super.protectedMethod();
    }
}
