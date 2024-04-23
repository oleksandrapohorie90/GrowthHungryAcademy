package Github_200days.strings;

public class MoreStringMethods {

    public static void main(String[] args) {
        String myText = "Four score and seven years ago";
        //is seven contains in above sentence str
        System.out.println(myText.concat("seven"));

        //concatenate a text
        String text1 = "this is my text1";
        String text2 = "this is my text2";
        System.out.println(text1 + " " + text2);
        System.out.println(text1.concat(text2));

        //if lots of Github_200days.business.strings together StringBuilder to build long Github_200days.business.strings
        String finalString = new StringBuilder(text1.length() + text2.length() + 1)
                .append(text1)
                .append(text2)
                .toString();
        System.out.println(finalString);
        String otherFinalStr = new StringBuilder()
                .append(text1)
                .append(" ")
                .append(text2)
                .toString();
        System.out.println(otherFinalStr);
        //if you know how many str's to concatenate
        System.out.format("%s", "%s\n", text1, text2);
        String oneMoreStr = String.format("%s", text1);

        //how many characters
        String myTexT = "for";
        char[] chars = myTexT.toCharArray();
        System.out.println(chars[2]);
        int index = 2;
        if (index < myTexT.length()) {
            System.out.println(chars[index]);
        }
    }
}
