package interfaces;

public interface FileProcessor {

    void encryptFile(String inputPath, String outputPath, int shift, CipherAlgorithm cipher)
            throws Exception;


    void decryptFile(String inputPath, String outputPath, int shift, CipherAlgorithm cipher)
            throws Exception;

}