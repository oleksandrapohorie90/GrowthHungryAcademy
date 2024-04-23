package Github_200days.text_parsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DecodeText {
    public class SubstitutionCipherDecoder {

        public static void main(String[] args) {
            String substitutionKey = "QWERTYUIOPASDFGHJKLZXCVBNM";
            String encodedFilePath = "encoded.txt";

            try {
                String encodedMessage = readEncodedMessageFromFile(encodedFilePath);
                String decodedMessage = decodeMessage(encodedMessage, substitutionKey);
                System.out.println("Decoded Message:");
                System.out.println(decodedMessage);
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        }

        private static String readEncodedMessageFromFile(String filePath) throws IOException {
            StringBuilder encodedMessage = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    encodedMessage.append(line);
                }
            }
            return encodedMessage.toString();
        }

        private static String decodeMessage(String encodedMessage, String substitutionKey) {
            StringBuilder decodedMessage = new StringBuilder();
            for (char c : encodedMessage.toCharArray()) {
                if (Character.isLetter(c)) {
                    int index = substitutionKey.indexOf(Character.toUpperCase(c));
                    if (index != -1) {
                        char decodedChar = Character.isUpperCase(c) ?
                                substitutionKey.charAt(index) :
                                Character.toLowerCase(substitutionKey.charAt(index));
                        decodedMessage.append(decodedChar);
                    } else {
                        decodedMessage.append(c);
                    }
                } else {
                    decodedMessage.append(c);
                }
            }
            return decodedMessage.toString();
        }
    }
}
