package fileProcessors;

import interfaces.CipherAlgorithm;
import interfaces.FileProcessor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StringFileProcessor implements FileProcessor {

    @Override
    public void encryptFile(String inputPath, String outputPath, int shift, CipherAlgorithm cipher) throws IOException {
        String text = Files.readString(Path.of(inputPath));
        String encryptedText = cipher.encrypt(text, shift);
        Files.writeString(Path.of(outputPath),encryptedText);
    }

    @Override
    public void decryptFile(String inputPath, String outputPath, int shift, CipherAlgorithm cipher) throws IOException {
        String text = Files.readString(Path.of(inputPath));
        String decryptedText = cipher.decrypt(text, shift);
        Files.writeString(Path.of(outputPath), decryptedText);
    }

}
