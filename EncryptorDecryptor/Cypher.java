package EncryptorDecryptor;

/**
 * abstract class Cypher represents basic set of encrypted/decrypted methods.
 */
public abstract class Cypher {
    public abstract char encryptAlgorithm(char initLetter, int key);
    public abstract char decryptAlgorithm(char initLetter, int key);
    public abstract void encryptedDataToConsole(String text, int key);
    public abstract void decryptedDataToConsole(String text, int key);
    public abstract void encryptDataToFile(String text, int key, String fileName);
    public abstract void decryptDataToFile(String text, int key, String fileName);

    /**
     * method writeToFile() allows write result of encryption/decryption on file.
     */

    static void writeToFile(String text, String fileName) {
        try {
            java.io.PrintWriter writer = new java.io.PrintWriter(fileName);
            writer.print(text);
            writer.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Error - no file have been found");
        }
    }
}
