package Github_200days.tasks;

public class FrequencyOfCharacters {
    public static void main(String[] args) {
        String str = "aaabbhgjsjsjjj";
        System.out.println(frequencyOfChars(str));
    }

    public static String frequencyOfChars(String str) {
        String r = "";
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            char current = str.charAt(i);
            if (!r.contains(current + "")) {
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == current) {
                        count++;
                    }
                }
                r += current + "" + count;
            }
        }
        return r;
    }
}
