package EncryptorDecryptor;

/**
 * class UnicodeCypher extends Class Cypher and implements algorithm of encrypt/decrypt based on Unicode symbols.
 */

public class UnicodeCypher extends Cypher {
    @Override
    public  char encryptAlgorithm(char initLetter, int key) {
        char finLetter;
        int firstBoundary = 0;
        int lastBoundary = 127;

        if (initLetter + key > lastBoundary) {
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
        int lastBoundary = 128;

        if (initLetter - key < firstBoundary && initLetter - key > 92) {
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
