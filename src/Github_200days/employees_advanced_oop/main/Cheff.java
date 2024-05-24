package Github_200days.employees_advanced_oop.main;

public interface Cheff {
    String favoriteFood = "hamburger";

    default void cook(String food){
        System.out.println("I am now cooking food");
    }

    default String cleanUp(){
        return "Im done cleaning up";
    }

    //String yellAtPeople();



}
