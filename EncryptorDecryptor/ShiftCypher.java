package EncryptorDecryptor;

/**
 * class ShiftCypher extends Class Cypher and implements algorithm of encrypt/decrypt by shifting.
 */
public class ShiftCypher extends Cypher {
    @Override
    public  char encryptAlgorithm(char initLetter, int key) {
        char finLetter;
        int firstBoundary = 0;
        int lastBoundary = 0;

        if (initLetter > 96 && initLetter < 123) {
            firstBoundary = 96;
            lastBoundary = 122;
        } else if (initLetter >= 65 && initLetter <= 90) {
            firstBoundary = 64;
            lastBoundary = 90;
        }

        if (initLetter <= firstBoundary || initLetter > lastBoundary) {
            finLetter = initLetter;
        } else if (initLetter + key > lastBoundary) {
            finLetter = (char) (firstBoundary + ((initLetter + key) - lastBoundary));
        } else {
            finLetter = (char) (initLetter + key);
        }

        return finLetter;
    }

    @Override
    public char decryptAlgorithm(char initLetter, int key) {
        char finLetter;
        int firstBoundary = 0;
        int lastBoundary = 0;

        if (initLetter > 96 && initLetter < 123) {
            firstBoundary = 97;
            lastBoundary = 123;
        } else if (initLetter > 64 && initLetter < 91) {
            firstBoundary = 65;
            lastBoundary = 91;
        }
        if (initLetter < firstBoundary || initLetter > lastBoundary) {
            finLetter = initLetter;
        }

        else if (initLetter - key < firstBoundary) {
            finLetter = (char) (lastBoundary - (firstBoundary - (initLetter - key)));
        } else {
            finLetter = (char) (initLetter - key);
        }
        return finLetter;
    }

    @Override
    public void encryptedDataToConsole(String text, int key) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(encryptAlgorithm(text.charAt(i), key));
        }
    }

    @Override
    public void decryptedDataToConsole(String text, int key) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(decryptAlgorithm(text.charAt(i), key));
        }
    }

    @Override
    public  void encryptDataToFile(String text, int key, String fileName) {
        char[] sequence = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            sequence[i] = encryptAlgorithm(text.charAt(i), key);
        }
        String newData = String.valueOf(sequence);
        writeToFile(newData, fileName);
    }

    @Override
    public  void decryptDataToFile(String text, int key, String fileName) {
        char[] sequence = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            sequence[i] = decryptAlgorithm(text.charAt(i), key);
        }
        String newData = String.valueOf(sequence);
        writeToFile(newData, fileName);
    }
}
