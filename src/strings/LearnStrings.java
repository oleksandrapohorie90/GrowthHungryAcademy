package strings;

public class LearnStrings {
    public static void main(String[] args) {
        String fruit = "apple"; //obj of type string
        String anotherFruit = "apple"; //obj of type string
        String vegetable = new String("broccoli"); //obj of type string
        String anotherVegetable = new String("broccoli");
//if keyword 'new' -> they are pointing to different memory address
        System.out.println(fruit == anotherFruit);
        System.out.println(vegetable == anotherVegetable);

        String myText = "abcdefg";
        System.out.println(myText.toUpperCase());
        String myText2 = "ABCDEF";
        System.out.println(myText.toLowerCase());

        //isBlank if there is no character displayed and isEmpty also will return true for " "
        //isEmpty, a space is a character, every character that is conveyed on the screen has a unicode
        String myText3 = " "; //false
        System.out.println(myText.isEmpty());

        String myText4 = "here's my awesome firf text";
        System.out.println(myText4.replace("firf", "nice"));
        System.out.println(myText4.replace('e', 'Z'));

        //remove front back space
        String firstName = " Jake ";
        System.out.format("'%s'", firstName.stripLeading());
        System.out.format("'%s'", firstName.stripTrailing());
        String firstName1 = """
                first line
                second line
                third line
                """;
        System.out.format("'%s'", firstName.stripTrailing());
        System.out.format("'%s'", firstName.trim()); //split is newer
        System.out.format("'%s'", firstName.split(firstName));
    }

    //split leading trailing spaces
    public static String split(String text) {

        return text.replace(" ", "");
    }

}



