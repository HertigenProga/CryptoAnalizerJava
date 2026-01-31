package fileProcessors;

import interfaces.CipherAlgorithm;
import interfaces.FileProcessor;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class BufferedFileProcessor implements FileProcessor {

    @Override
    public void encryptFile(String inputPath, String outputPath, int shift, CipherAlgorithm cipher) throws Exception {
        processLineByLine(inputPath, outputPath, shift, cipher, true);
    }

    @Override
    public void decryptFile(String inputPath, String outputPath, int shift, CipherAlgorithm cipher) throws Exception {
        processLineByLine(inputPath, outputPath, shift, cipher, false);
    }

    private void processLineByLine(String inputPath, String outputPath, int shift, CipherAlgorithm cipher, boolean encrypt) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(inputPath), StandardCharsets.UTF_8)
                );
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(outputPath), StandardCharsets.UTF_8)
                )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String out = encrypt ? cipher.encrypt(line, shift) : cipher.decrypt(line, shift);
                writer.write(out);
                writer.newLine();
            }
        }
    }
}

