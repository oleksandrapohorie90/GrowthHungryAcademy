package Github_200days.strings;

public class Substring {
    public static void main(String[] args) {
        String myText = "apple";
        //start on the 0 index and only give us the 1 char
        String myNewText = myText.substring(0, 1).toUpperCase();
        //to print capital A+pple
        //I can replace myText.substring(0,1)=firstPart var
        //.substring(1)=second var
        String myNewText1 = myText.substring(0, 1)
                .toUpperCase()
                .concat(myText
                        .substring(1));
        String myNewText2 = new StringBuilder().append(myText.substring(0, 1))
                .append(myText
                        .substring(1)).toString();
        String myNewText3 = "four score and seven years ago";
        //where in the str word seven
        System.out.println(myNewText3.indexOf("seven"));
        //last time you find a match
        System.out.println(myNewText3.lastIndexOf("a"));
        //start looking/searching from the 3char => index 2
        System.out.println(myNewText3.indexOf("a", 2));

        //write a code that extract out parts of a phone number
        String phoneNumber = "(234) 333-5551".strip(); //to get rid of spaces
        String areaCode = parseAreaCode(phoneNumber);
        String exchange = parseExchange(phoneNumber);
        String lineNumber = parseLineNumber(phoneNumber);
        System.out.println(areaCode);
        System.out.println(exchange);
        System.out.println(lineNumber);
    }
        public static String parseAreaCode(String phoneNumber){
        //look for parenthesis first (
            int openParens = phoneNumber.indexOf("(");
            int closeParens = phoneNumber.indexOf(")");
            String areaCode = phoneNumber.substring(openParens+1,closeParens);
        return areaCode;
        }
        public static String parseExchange(String phoneNumber){
        //you have to search to anchor the next part
            int openParens = phoneNumber.indexOf(" ");
            int closeParens = phoneNumber.indexOf("-");
            String exchange = phoneNumber.substring(openParens+1,closeParens);
            return exchange;
        }
        public static String parseLineNumber(String phoneNumber){
            int hyphen = phoneNumber.indexOf("-");
            //if don't supply the end it will return from the value to the end
            String lineNum = phoneNumber.substring(hyphen+1);
            return lineNum;
        }



}
