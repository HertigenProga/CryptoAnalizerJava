package implementation;

import fileProcessors.BufferedFileProcessor;
import interfaces.CipherAlgorithm;
import interfaces.FileProcessor;
import validation.InputValidator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CipherAlgorithm cipher = new Cipher();
        FileProcessor processor = new BufferedFileProcessor();
        // if you want to go through String:
        // FileProcessor processor = new StringFileProcessor();

        while (true) {
            System.out.println("1 - Encrypt file");
            System.out.println("2 - Decrypt file");
            System.out.println("0 - Exit");
            System.out.print("Select: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Enter a number");
                scanner.nextLine();
                continue;
            }

            if (choice == 0) {
                System.out.println("Exit the program");
                break;
            }

            try {
                System.out.print("Path to input file: ");
                String inputPath = scanner.nextLine();

                System.out.print("Path to output file: ");
                String outputPath = scanner.nextLine();

                System.out.print("Key (shift): ");
                int shift = scanner.nextInt();
                scanner.nextLine();

                InputValidator.validateInputFile(inputPath);
                shift = InputValidator.validateAndNormalizeShift(
                        shift,
                        Cipher.ALPHABET.length());

                if (choice == 1) {
                    processor.encryptFile(inputPath, outputPath, shift, cipher);
                    System.out.println("The file has been successfully encrypted");
                } else if (choice == 2) {
                    processor.decryptFile(inputPath, outputPath, shift, cipher);
                    System.out.println("The file has been successfully decrypted");
                } else {
                    System.out.println("Incorrect menu item");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }

        scanner.close();
    }
}
