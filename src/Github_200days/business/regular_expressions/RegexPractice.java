package Github_200days.business.regular_expressions;

public class RegexPractice {
    public static void main(String[] args) {
        //just literal expression, does this cat matches this
        //if the 2nd word starts with lower or upper case it is a match
        System.out.println("Cat".toLowerCase().matches("[cC]at"));
        //allow all chars except lower case c with ^ sign -> XOR
        System.out.println("Cat".toLowerCase().matches("[^c]at"));
        //dont allow any chars from a through z
        System.out.println("Cat".toLowerCase().matches("[^a-z]at"));
        System.out.println("cat".matches("cat"));
        //either lower or upper case C -> [] mean if the word starts from lower/upper than its a match
        System.out.println("bat".toLowerCase().matches("[cBCb]at"));
        //false
        System.out.println("get".toLowerCase().matches("[a-f]at"));
        //true -> as long as the 1st char in a word is not a c it is a match
        System.out.println("get".toLowerCase().matches("[^c]at"));
        //any char from a through z shouldnt be allowed
        System.out.println("Lat".toLowerCase().matches("[^a-z]at"));
        System.out.println("Lat".matches("\\wat"));
        System.out.println("321-333-7652".matches("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d"));
        //false
        System.out.println("321-333-7652".matches("\\d{3}-\\d{3}-\\d{4}"));
        //true, \\s - stands for space, for 1 or more any of these chars [-,.\\s]+
        System.out.println("321-333-7652".matches("\\d{3}[-,.\\s]\\d{3}[-,.\\s]\\d{4}"));
        //zero or more characters preceiding
        System.out.println("321-333-7652".matches("\\d{3}[-,.\\s]*\\d{3}[-,.\\s]*\\d{4}"));

        //at the end we will allow 3 to 4 digits
        System.out.println("321-333-7652".matches("\\d{3}[-,.\\s]?\\d{3}[-,.\\s]?\\d{3,4}"));
        //atleast 3 digits long
        System.out.println("321-333-7652".matches("\\d{3}[-,.\\s]?\\d{3}[-,.\\s]?\\d{3,}"));
        //match 1st 3 digits 2 times -> true
        System.out.println("321-333-7652".matches("(\\d{3}[-,.\\s]?){2}\\d{4}"));

        //To match north america phone num
        System.out.println("1.321.333.7652".matches("\\d{1}[.]\\d{3}[.]\\d{3}[.]\\d{4}"));
        //to make 1st bit optional, ? mark means for signs -,.\\s to have a choice 0 or more, any of them or none return true
        System.out.println("321-333-7652".matches("(\\d[-,.\\s]?)?(\\d{3}[-,.\\s]?){1,2}\\d{4}"));
    }
}
