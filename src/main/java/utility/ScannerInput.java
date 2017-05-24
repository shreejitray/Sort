package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by schaud3 on 5/24/17.
 */
public class ScannerInput {
    public Scanner input (String fileName) throws IOException {
        File file = new File(new File("./src/main/java/").getCanonicalPath() +fileName );
        Scanner in = new Scanner(file);
        return in;
    }
}
