package data_structures_and_algorithms.week18;

public class StringCompression {
    //Main goal to analyze the array and find chars and put 1st = that char, 2nd = the number of how many times that char appears in the array

    //each char essentially is making a string of 1 or more chars
    //int streakStart=0 - points at the beginning at the next string
    //int indexAnswer=0 - points to where I will be writing my answer, this will be directly overwritting since we cant create a new array
    //array is broken by parts - 'streaks'


    public int compress(char[] chars) {
        int n = chars.length;

        int streakStart = 0;
        int indexAnswer = 0;

        while (streakStart < n) { //when its n means i finished process in the whole string
            //current streak starts w/ chars[streakStart]
            char streakChar = chars[streakStart];

            //count how many consecutive streakChar-s there are in this streak
            //streakStart and streakEnd are the two pointers. Its commong teqnique
            int streakEnd = streakStart; //streakEnd is the 2nd pointer
            int count = 1; //in the beginning I have at least 1 character which is at position streakStart
            while (streakEnd + 1 < n && chars[streakEnd + 1] == streakChar) { //chars[streakEnd+1] == streakChar  -> this checks if its the same char then I want to extend my count, so now will be "a2" for example instead of "a1"
                streakEnd++;
                count++; //this is the number in the string
            }

            //?? b12 => "b" "1" "2"
            //if count ==1 -> then we should write in 'chars' just the 'streakChar'
            //else -> then we should write in 'chars' the 'streakChar' followed by the integer 'count'
            chars[indexAnswer] = streakChar; //indexAnswer - for my answer
            indexAnswer++;
//**NOTE if my int count = 1 then i should just return the char and no numbers after it, if count is more then 1 then I have to add numbers
            if (count > 1) {//i convert my count into a string and into character array
                char[] countAsChars = Integer.toString(count).toCharArray();
                for (char digit : countAsChars) {
                    chars[indexAnswer] = digit;
                    indexAnswer++;
                }
            }
            streakStart = streakEnd + 1;

        }
        return indexAnswer;
    }
}
