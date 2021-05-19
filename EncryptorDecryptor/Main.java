package EncryptorDecryptor;

public class Main {
    public static void main(String[] args) {
        Work work = new Work();
        work.menu(args);
        Work.chooseCypher(Work.algorithm);
    }
}
