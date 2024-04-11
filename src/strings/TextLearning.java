package strings;

public class TextLearning {
    public static void main(String[] args) {
        String text = """
            Smith,Fred,1/1/79
            Aurora,Jackson,1/2/88
            Jenny,Brown,1/9/95""";
        String[] people = text.split("\n");
/*
        System.out.println(people.length);
        System.out.println(people[4]);
        people[4].split(",");
        String[] george = people[4].split(",");
        System.out.println(george[3]);
*/
        String filename = "myfile.txt";
        System.out.println(filename.endsWith("txt"));
        System.out.println(filename.startsWith("myfile"));

        String firstText = "Apple";
        String secondText = "Apple";
        //StringBuffer sb = new StringBuffer("Apple");
        StringBuilder sb = new StringBuilder("Apple");
        boolean b = firstText.contentEquals(secondText);
        System.out.println(b);
        String name = "Alex";
        int age = 29;

        //updates for java 21-22
        System.out.println("Hello my name is " + name +" and I am" +age+ " years old.");
        System.out.printf("Hello my name is %s and I am %d years old.\n",name,age);
        //System.out.printf(STR."Hello my name is \{name} and I am \{age+10} years old.");
        //%s - string
        //%d - integer

    }
}
