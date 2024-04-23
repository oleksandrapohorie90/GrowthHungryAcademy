package Github_200days.numbers;

public class NumberSystems {
    /*
BYTE (-128 TO 127)
    A -> in ASCII is 65
    lowest level is bit
    1 bit can hold 1 or 0
    A BYTE is 8 bits put together

    8   7  6  5  4 3 2 1
    128 64 32 16 8 4 2 1 <= doubling themselves 2^
65=     1  0  0  0 0 0 1 <= decimal 65 in binary encoding
9=               1 0 0 1
7=                 1 1 1
13=              1 1 0 1
37=        1  0  0 1 0 1

Hexadecimal - for each place 16 diff values 0-9, A-F
A=10, B=11, C=12, D=13, E=14, F=15
8 4 2 1  8 4 2 1  8 4 2 1
    1 1  1 1 1 0  1 0 0 0 => 3E8 in Hexadecimal
    3    E        8

8 4 2 1  8 4 2 1  8 4 2 1  8 4 2 1
1 1 1 1  1 0 1 0  1 1 0 0  1 1 1 0 => FACE
F        A        C        E
15       10       12       14


     */
    public static void main(String[] args) {
        boolean myFlag = true;
        byte myByte = 12;
        short myBigShort = 45;
        char myChar = 'A'; //65

    }
}
