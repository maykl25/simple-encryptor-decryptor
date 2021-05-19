package EncryptorDecryptor;

/**
 * class Work performs actions with chosen type of encrypt/decrypt.
 */

public class Work {
    public static String mode;
    public static int key;
    public static String data;
    public static String inPath = "";
    public static String outPath = "";
    public static String algorithm = "";
    public static java.util.ArrayList<String> parameters = new java.util.ArrayList<>();


    /**
     * method chooseCypher() allows to choose preferable type of encryption/decryption algorithm.
     * @param alg
     * @return
     */

    public static Cypher chooseCypher(String alg) {
        Cypher cypher = null;
        switch (alg) {
            case "shift":
                cypher = new ShiftCypher();
                action(mode, key, data, cypher);
                break;
            case "unicode":
                cypher = new UnicodeCypher();
                action(mode, key, data, cypher);
                break;
        }
        return cypher;
    }

    /**
     * method action() allows to choose where to write encrypted/decrypted data - to console or to file.
     * @param option
     * @param number
     * @param text
     * @param cypher
     */

    public static void action(String option, int number, String text, Cypher cypher) {
        if (outPath.isEmpty()) {
            switch (option) {
                case "enc":
                    cypher.encryptedDataToConsole(text, number);
                    break;
                case "dec":
                    cypher.decryptedDataToConsole(text, number);
                    break;
            }
        } else {
            switch (option) {
                case "enc":
                    cypher.encryptDataToFile(text, number, outPath);
                    break;
                case "dec":
                    cypher.decryptDataToFile(text, number, outPath);
                    break;
            }
        }
    }

    /**
     * method readFromFile() allows to read data for encryption/decryption from side file.
     * @param fileName
     * @return
     */

    static String readFromFile(String fileName) {
        String fileText = " ";
        java.io.File file = new java.io.File(fileName);
        try {
            java.util.Scanner scanner = new java.util.Scanner(file);
            fileText = scanner.nextLine();
            scanner.close();
        } catch(java.io.FileNotFoundException e) {
            System.out.println("Error, file not found");
        }
        return fileText;
    }

    /**
     * special method menu() allows to read command line arguments.
     * @param array
     */

    public  void menu(String[] array) {
        for (int i = 0; i < array.length; i++) {
            parameters.add(array[i]);
        }
        for (int i = 0; i < parameters.size(); i += 2) {
            if (parameters.get(i).equals("-mode")) {
                mode = parameters.get(i + 1);
            } else if (!parameters.contains("-mode")) {
                mode = "enc";
            }
            if (parameters.get(i).equals("-key")) {
                key = Integer.parseInt(parameters.get(i + 1));
            } else if (!parameters.contains("-key")) {
                key = 0;
            }
            if (parameters.get(i).equals("-data")) {
                data = parameters.get(i + 1);
            } else if (!parameters.contains("-data")) {
                data = " ";
            }
            if (parameters.get(i).equals("-alg")) {
                algorithm = parameters.get(i + 1);
            } else if (!parameters.contains("-alg")) {
                algorithm = "shift";
            }

            if (parameters.get(i).equals("-in")) {
                inPath = parameters.get(i + 1);
            }
            if (parameters.get(i).equals("-out")) {
                outPath = parameters.get(i + 1);
            }
        }
        if (data.equals(" ") && !inPath.isEmpty()) {
            data = readFromFile(inPath);
        }

    }
}
