package validation;

import java.io.File;
import java.io.IOException;

public class InputValidator {
    public static void validateInputFile(String inputPath) throws IOException {
        if (inputPath == null || inputPath.isBlank()) {
            throw new IOException("The path to the input file is not specified");
        }
        File file = new File(inputPath);
        if (!file.exists()) {
            throw new IOException("The input file does not exist");
        }
        if (!file.isFile()) {
            throw new IOException("The specified path is not a file");
        }
        if (!file.canRead()) {
            throw new IOException("No permissions to read the input file");
        }
    }

    public static int validateAndNormalizeShift(int shift, int alphabetLength) {
    if (shift < 0){
        throw new IllegalArgumentException("The key cannot be negative");
    }
        return shift % alphabetLength;
    }
}

